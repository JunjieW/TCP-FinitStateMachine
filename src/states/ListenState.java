package states;

import Fsm.State;

public class ListenState extends State{
	private static ListenState singleton = new ListenState("LISTEN");
	
	private ListenState(String name) {super(name);}
	
	public static ListenState getInstance() {return singleton;}
}
