package tcpfsm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Fsm.Event;
import Fsm.FSM;
import Fsm.FsmException;
import Fsm.State;
import Fsm.Transition;
import actions.CommonAction;
import events.AckReceivedEvent;
import events.ActiveOpenEvent;
import events.CloseEvent;
import events.DataReceivedEvent;
import events.DataSentEvent;
import events.FinReceivedEvent;
import events.PassiveOpenEvent;
import events.SynAckReceivedEvent;
import events.SynReceivedEvent;
import events.TimedWaitEndsEvent;
import states.ClosedState;
import states.ClosingState;
import states.EstablishedState;
import states.FinWaitOneState;
import states.FinWaitTwoState;
import states.LastAckState;
import states.ListenState;
import states.SynCloseState;
import states.SynRcvdState;
import states.SynSentState;
import states.TimeWaitState;

public class FSMMain {
	
	public static void main(String[] args) {				
		Scanner sc = null;
		File f = null;
		
		// System.out.println("Please enter the input file, or q to quit:");
		if (args.length != 1) { 
			System.out.println("Please provide the input files");
		}
		
		try {
			f = new File(args[0]);
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (Exception e) {
			System.out.println("Something goes wrong, try again");
		}
		
		// start TCP-FSM
		FSM fsm = new FSM("TCP-FSM", ClosedState.getInstance());
		fsm.traceOff();
		try {
			// CLOSED State outgoing transitions
			fsm.addTransition(new Transition(ListenState.getInstance(), CloseEvent.getInstance(), ClosedState.getInstance(), new CommonAction()));
			//fsm.addTransition(new Transition(ListenState.getInstance(), SendEvent.getInstance(), SynSentState.getInstance(), new CommonAction()));
			fsm.addTransition(new Transition(ListenState.getInstance(), SynReceivedEvent.getInstance(), SynRcvdState.getInstance(), new CommonAction()));
			
			// LISTEN State outgoing transitions
			fsm.addTransition(new Transition(ClosedState.getInstance(), PassiveOpenEvent.getInstance(), ListenState.getInstance(), new CommonAction()));
			fsm.addTransition(new Transition(ClosedState.getInstance(), ActiveOpenEvent.getInstance(), SynSentState.getInstance(), new CommonAction()));
			
			// SYN_RCVD State outgoing transitions
			fsm.addTransition(new Transition(SynRcvdState.getInstance(), CloseEvent.getInstance(), FinWaitOneState.getInstance(), new CommonAction()));
			fsm.addTransition(new Transition(SynRcvdState.getInstance(), AckReceivedEvent.getInstance(), EstablishedState.getInstance(), new CommonAction()));
			
			// SYN_SENT State outgoing transitions			
			fsm.addTransition(new Transition(SynSentState.getInstance(), CloseEvent.getInstance(), ClosedState.getInstance(), new CommonAction()));
			fsm.addTransition(new Transition(SynSentState.getInstance(), SynReceivedEvent.getInstance(), SynRcvdState.getInstance(), new CommonAction()));
			fsm.addTransition(new Transition(SynSentState.getInstance(), SynAckReceivedEvent.getInstance(), EstablishedState.getInstance(), new CommonAction()));
			
			// ESTABLISHED State outgoing transitions
			fsm.addTransition(new Transition(EstablishedState.getInstance(), CloseEvent.getInstance(), FinWaitOneState.getInstance(), new CommonAction()));
			fsm.addTransition(new Transition(EstablishedState.getInstance(), FinReceivedEvent.getInstance(), SynCloseState.getInstance(), new CommonAction()));
			fsm.addTransition(new Transition(EstablishedState.getInstance(), DataReceivedEvent.getInstance(), EstablishedState.getInstance(), new CommonAction()));
			fsm.addTransition(new Transition(EstablishedState.getInstance(), DataSentEvent.getInstance(), EstablishedState.getInstance(), new CommonAction()));
			
			// FIN_WAIT_1 State outgoing transitions			
			fsm.addTransition(new Transition(FinWaitOneState.getInstance(), FinReceivedEvent.getInstance(), ClosingState.getInstance(), new CommonAction()));
			fsm.addTransition(new Transition(FinWaitOneState.getInstance(), AckReceivedEvent.getInstance(), FinWaitTwoState.getInstance(), new CommonAction()));
			
			// FIN_WAIT_2 State outgoing transitions				
			fsm.addTransition(new Transition(FinWaitTwoState.getInstance(), FinReceivedEvent.getInstance(), TimeWaitState.getInstance(), new CommonAction()));
			
			// CLOSING State outgoing transitions	
			fsm.addTransition(new Transition(ClosingState.getInstance(), AckReceivedEvent.getInstance(), TimeWaitState.getInstance(), new CommonAction()));
			
			// TIME_WAIT State outgoing transitions	
			fsm.addTransition(new Transition(TimeWaitState.getInstance(), TimedWaitEndsEvent.getInstance(), ClosedState.getInstance(), new CommonAction()));
			
			// SYNC_CLOSE State outgoing transitions				
			fsm.addTransition(new Transition(SynCloseState.getInstance(), CloseEvent.getInstance(), LastAckState.getInstance(), new CommonAction()));
			
			// LAST_ACK State outgoing transitions
			fsm.addTransition(new Transition(LastAckState.getInstance(), AckReceivedEvent.getInstance(), ClosedState.getInstance(), new CommonAction()));
		} catch (FsmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (sc.hasNext()) {
			String token = sc.next();
			try{
			switch(token) {
				case "PASSIVE": fsm.doEvent(PassiveOpenEvent.getInstance()); break;
				case "ACTIVE": fsm.doEvent(ActiveOpenEvent.getInstance()); break;
				case "SYN": fsm.doEvent(SynReceivedEvent.getInstance()); break;
				case "SYNACK": fsm.doEvent(SynAckReceivedEvent.getInstance()); break;
				case "ACK": fsm.doEvent(AckReceivedEvent.getInstance()); break;
				case "RDATA": fsm.doEvent(DataReceivedEvent.getInstance()); break;
				case "SDATA": fsm.doEvent(DataSentEvent.getInstance()); break;
				case "FIN": fsm.doEvent(FinReceivedEvent.getInstance()); break;
				case "CLOSE": fsm.doEvent(CloseEvent.getInstance()); break;
				case "TIMEOUT": fsm.doEvent(TimedWaitEndsEvent.getInstance()); break;
			}
			} catch (FsmException fsme) {
				System.out.println("Error: unexpected Event: " + token);
				continue;
			}
				
		}
		sc.close();
	
	}

}
