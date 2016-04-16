package states;

import Fsm.State;

public class FinWaitOneState extends State{

	private static FinWaitOneState singleton = new FinWaitOneState("FIN_WAIT_1");
	
	private FinWaitOneState(String name) {super(name);}
	
	public static FinWaitOneState getInstance() {return singleton;}
}
