package monopoly;
import java.util.Vector;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public abstract class MessageSender {

	private Vector<Observer> observers;
	
	/**
	 * Constructor of MessageSender class
	 */
	public MessageSender() {
		observers = new Vector<Observer>();
	}
	
	/**
	 * 
	 * @param message message to be notified
	 */
	public void notice(String message) {
		for (Observer o:observers) {
			o.update(message);
		}
	}
	
	/**
	 * the notify
	 */
	public void notice() {
		for (Observer o:observers) {
			o.update();
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
