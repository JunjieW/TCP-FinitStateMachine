package transitions;

import Fsm.Action;
import Fsm.Event;
import Fsm.State;
import Fsm.Transition;


public class ClosedToListen extends Transition {

	public ClosedToListen(State cs, Event evt, State ns, Action act) {
		super(cs, evt, ns, act);
	}

}
