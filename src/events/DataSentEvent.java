package events;

import Fsm.Event;

public class DataSentEvent extends Event {
	private static DataSentEvent singleton = new DataSentEvent("Data to be sent from application");
	
	private DataSentEvent(String name) {super(name);}

	private DataSentEvent(String name, Object obj) { super(name, obj);}
	
	public static DataSentEvent getInstance() {return singleton;}

}
