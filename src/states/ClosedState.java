package states;

import Fsm.State;

public class ClosedState extends State{
	private static ClosedState singleton = new ClosedState("CLOSED");
	
	private ClosedState(String name) {super(name);}
	
	public static ClosedState getInstance() {return singleton;}
}
