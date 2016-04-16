package events;

import Fsm.Event;

public class SynReceivedEvent extends Event {
	private static SynReceivedEvent singleton = new SynReceivedEvent("SYN received");
	
	private SynReceivedEvent(String name) {super(name);}

	private SynReceivedEvent(String name, Object obj) { super(name, obj);}
	
	public static SynReceivedEvent getInstance() {return singleton;}

}
