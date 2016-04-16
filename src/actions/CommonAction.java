package actions;

import Fsm.Action;
import Fsm.Event;
import Fsm.FSM;
import events.DataReceivedEvent;
import events.DataSentEvent;
import events.TimedWaitEndsEvent;
import states.EstablishedState;
import states.LastAckState;

public class CommonAction extends Action {
	
	public CommonAction() {}

	@Override
	public void execute(FSM fsm, Event event) {
		if (event instanceof DataReceivedEvent) {
			EstablishedState es = (EstablishedState)fsm.currentState();
			System.out.println("DATA received " + ++ es.rcvCounter);
		} else if (event instanceof DataSentEvent) {
			EstablishedState es = (EstablishedState)fsm.currentState();
			System.out.println("DATA sent " + ++ es.sentCounter);
		} else if (event instanceof TimedWaitEndsEvent){
			EstablishedState.getInstance().resetCouters();
		} else if (fsm.currentState() instanceof LastAckState) {
			EstablishedState.getInstance().resetCouters();
		} else {
			System.out.println("Event " + event.getName() + " received, current State is " + fsm.currentState().getName());
		}
	}

}
