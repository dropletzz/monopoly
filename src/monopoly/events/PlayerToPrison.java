package monopoly.events;

import monopoly.Player;
import monopoly.event_handlers.Event;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class PlayerToPrison implements Event {
	
	private Player player;
	
	/**
	 * Constructor of PlayerToPrison class
	 * @param player the player who call the event
	 */
	public PlayerToPrison(Player player) {
		this.player = player;
	}
	
	/**
	 * 
	 * @return the message of the event to go to prison
	 */
	public String getMessage() {
		return String.format("%s finisce in prigione!", player.getName());
	}
}