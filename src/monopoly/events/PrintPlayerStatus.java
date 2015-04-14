package monopoly.events;

import monopoly.Player;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class PrintPlayerStatus implements Event {

	private Player player;
	
	/**
	 * Constructor of PrintPlayerStatus class
	 * @param p the player
	 */
	public PrintPlayerStatus(Player p) {
		player = p;
	}
	
	/**
	 * 
	 * @return the message of the status of player
	 */
	@Override
	public String getMessage() {
		return "";
	}
	
	/**
	 * 
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}
}