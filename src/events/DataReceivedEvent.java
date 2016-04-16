package events;

import Fsm.Event;

public class DataReceivedEvent extends Event {
	private static DataReceivedEvent singleton = new DataReceivedEvent("Data received from network");
	
	private DataReceivedEvent(String name) {super(name);}

	private DataReceivedEvent(String name, Object obj) { super(name, obj);}
	
	public static DataReceivedEvent getInstance() {return singleton;}

}