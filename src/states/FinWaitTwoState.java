package states;

import Fsm.State;

public class FinWaitTwoState extends State{

	private static FinWaitTwoState singleton = new FinWaitTwoState("FIN_WAIT_2");
	
	private FinWaitTwoState(String name) {super(name);}
	
	public static FinWaitTwoState getInstance() {return singleton;}

}
