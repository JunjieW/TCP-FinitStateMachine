package events;

import Fsm.Event;

public class FinReceivedEvent extends Event {
	private static FinReceivedEvent singleton = new FinReceivedEvent("FIN received");
	
	private FinReceivedEvent(String name) {super(name);}

	private FinReceivedEvent(String name, Object obj) { super(name, obj);}
	
	public static FinReceivedEvent getInstance() {return singleton;}

}

