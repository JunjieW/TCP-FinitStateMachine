package events;

import Fsm.Event;

public class CloseEvent extends Event {
	private static CloseEvent singleton = new CloseEvent("Client or Server issues close()");
	
	private CloseEvent(String name) {super(name);}

	private CloseEvent(String name, Object obj) { super(name, obj);}
	
	public static CloseEvent getInstance() {return singleton;}

}