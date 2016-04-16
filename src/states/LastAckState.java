package states;

import Fsm.State;

public class LastAckState extends State{
	private static LastAckState singleton = new LastAckState("LAST_ACK");
	
	private LastAckState(String name) {super(name);}
	
	public static LastAckState getInstance() {return singleton;}
}
