package monopoly.event_handlers;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public interface Observer {
	/**
	 * 
	 * @param e the event 
	 */
	public void handleEvent(Event e);
}
