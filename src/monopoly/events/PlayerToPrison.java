package monopoly.events;

/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class PlayerToPrison implements Event {
	
	/**
	 * Constructor of PlayerToPrison class
	 * @param player the player who call the event
	 */
	public PlayerToPrison() {}
	
	/**
	 * 
	 * @return the message of the event to go to prison
	 */
	public String getMessage() {
		return String.format("sei finito in prigione!");
	}
}