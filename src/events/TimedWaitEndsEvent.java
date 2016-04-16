package events;

import Fsm.Event;

public class TimedWaitEndsEvent extends Event {
	private static TimedWaitEndsEvent singleton = new TimedWaitEndsEvent("Timed wait ends");
	
	private TimedWaitEndsEvent(String name) {super(name);}

	private TimedWaitEndsEvent(String name, Object obj) { super(name, obj);}
	
	public static TimedWaitEndsEvent getInstance() {return singleton;}

}
