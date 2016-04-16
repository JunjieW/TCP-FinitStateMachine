package states;

import Fsm.State;

public class SynRcvdState extends State{
	private static SynRcvdState singleton = new SynRcvdState("SYT_RCVD");
	
	private SynRcvdState(String name) {super(name);}
	
	public static SynRcvdState getInstance() {return singleton;}
}
