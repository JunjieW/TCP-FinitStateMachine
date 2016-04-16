package states;

import Fsm.State;

public class EstablishedState extends State{
	public int rcvCounter;
	public int sentCounter;
	
	private static EstablishedState singleton = new EstablishedState("ESTABLISHED");
	
	private EstablishedState(String name) {
		super(name);
		resetCouters();
	}
	
	public static EstablishedState getInstance() {return singleton;}
	
	public void resetCouters() {
		rcvCounter = 0;
		rcvCounter = 0;
	}

}
