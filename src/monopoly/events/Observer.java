package monopoly.events;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public interface Observer {
	/**
	 * 
	 * @param message 
	 */
	public void handleEvent(Event e);
}
