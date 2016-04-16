package events;

import Fsm.Event;

public class ActiveOpenEvent extends Event {
	private static ActiveOpenEvent singleton = new ActiveOpenEvent("Active Open");
	
	private ActiveOpenEvent(String name) {super(name);}

	private ActiveOpenEvent(String name, Object obj) { super(name, obj);}
	
	public static ActiveOpenEvent getInstance() {return singleton;}

}
