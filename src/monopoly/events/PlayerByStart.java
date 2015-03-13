package monopoly.events;

import monopoly.Player;
import monopoly.event_handlers.Event;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class PlayerByStart implements Event {
	
	private Player player;
	
	/**
	 * Constructor of PlayerByStart class
	 * @param player
	 */
	public PlayerByStart(Player player) {
		this.player = player;
	}
	
	/**
	 * 
	 * @return the message of the event to pass by start
	 */
	public String getMessage() {
		return String.format("%s e' passato dalla casella START: riceve 500.00 euro!", player.getName());
	}
}