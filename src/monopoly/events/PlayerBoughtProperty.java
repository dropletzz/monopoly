package monopoly.events;

import monopoly.Player;
import monopoly.event_handlers.Event;
import monopoly.slots.Property;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class PlayerBoughtProperty implements Event {
	
	private Player player;
	private Property property;
	
	/**
	 * Constructor of PlayerBoughtProperty class
	 * @param player
	 * @param property
	 */
	public PlayerBoughtProperty(Player player, Property property) {
		this.player = player;
		this.property = property;
	}

	/**
	 * 
	 * @return the message of the event to bought the property
	 */
	public String getMessage() {
		return String.format("%s ha comprato %s", player.getName(), property.getName());
	}

	/**
	 * 
	 * @return the player has bought property
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * 
	 * @return the property that has been bought
	 */
	public Property getProperty() {
		return property;
	}
}

