package events;

import Fsm.Event;

public class PassiveOpenEvent extends Event {
	private static PassiveOpenEvent singleton = new PassiveOpenEvent("Passive Open");
	
	private PassiveOpenEvent(String name) {super(name);}

	private PassiveOpenEvent(String name, Object obj) { super(name, obj);}
	
	public static PassiveOpenEvent getInstance() {return singleton;}

}
