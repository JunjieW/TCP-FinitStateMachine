package states;

import Fsm.State;

public class TimeWaitState extends State{
	private static TimeWaitState singleton = new TimeWaitState("TIME_WAIT");
	
	private TimeWaitState(String name) {super(name);}
	
	public static TimeWaitState getInstance() {return singleton;}
}
