package states;

import Fsm.State;

public class ClosingState extends State{

	private static ClosingState singleton = new ClosingState("CLOSING");
	
	private ClosingState(String name) {super(name);}
	
	public static ClosingState getInstance() {return singleton;}

}
