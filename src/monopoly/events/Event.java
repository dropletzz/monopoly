package monopoly.events;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public abstract class Event {

	/**
	 * Constructor of Event class
	 */
	public Event() {}
	
	/**
	 * 
	 * @return the message of the event
	 */
	public abstract String getMessage();
}
