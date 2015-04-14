package monopoly.events;

/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class PlayerByStart implements Event {
	
	/**
	 * Constructor of PlayerByStart class
	 */
	public PlayerByStart() {}
	
	/**
	 * 
	 * @return the message of the event to pass by start
	 */
	public String getMessage() {
		return String.format("sei passato dalla casella START: ricevi 500.00 euro!");
	}
}