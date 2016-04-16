package states;

import Fsm.State;

public class SynCloseState extends State {

	private static SynCloseState singleton = new SynCloseState("SYC_CLOSE");
	
	private SynCloseState(String name) {super(name);}
	
	public static SynCloseState getInstance() {return singleton;}
}
