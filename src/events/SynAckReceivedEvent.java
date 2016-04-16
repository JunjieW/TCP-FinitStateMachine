package events;

import Fsm.Event;

public class SynAckReceivedEvent extends Event {
	private static SynAckReceivedEvent singleton = new SynAckReceivedEvent("SYN + ACK received");
	
	private SynAckReceivedEvent(String name) {super(name);}

	private SynAckReceivedEvent(String name, Object obj) { super(name, obj);}
	
	public static SynAckReceivedEvent getInstance() {return singleton;}

}