package monopoly.event_handlers;
import java.util.Vector;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public abstract class EventGenerator {

	private Vector<Observer> observers;
	
	/**
	 * Constructor of MessageSender class
	 */
	public EventGenerator() {
		observers = new Vector<Observer>();
	}
	
	/**
	 * 
	 * @param message message to be notified
	 */
	public void notice(Event e) {
		for (Observer o:observers) {
			o.handleEvent(e);
		}
	}
	
	/**
	 * 
	 * @param o add to the list of observers
	 */
	public void addObserver(Observer o) {
		observers.add(o);
	}
}
