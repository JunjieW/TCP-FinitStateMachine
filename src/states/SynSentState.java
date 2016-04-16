package states;

import Fsm.State;

public class SynSentState extends State{
	private static SynSentState singleton = new SynSentState("SYT_SENT");
	
	private SynSentState(String name) {super(name);}
	
	public static SynSentState getInstance() {return singleton;}
}
