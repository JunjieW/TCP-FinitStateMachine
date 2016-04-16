package events;

import Fsm.Event;

public class AckReceivedEvent extends Event {
	private static AckReceivedEvent singleton = new AckReceivedEvent("ACK received");
	
	private AckReceivedEvent(String name) {super(name);}

	private AckReceivedEvent(String name, Object obj) { super(name, obj);}
	
	public static AckReceivedEvent getInstance() {return singleton;}

}

