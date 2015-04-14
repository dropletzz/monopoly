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
public class PlayerPaidForProperty implements Event {
	
	private Player player;
	private Player owner;
	private Property property;
	
	/**
	 * Constructor of PlayerPaidForProperty class
	 * @param player
	 * @param owner
	 * @param property
	 */
	public PlayerPaidForProperty(Player player, Player owner, Property property) {
		this.player = player;
		this.owner = owner;
		this.property = property;
	}

	/**
	 * 
	 * @return the message of the event player paid for the property
	 */
	public String getMessage() {
		return String.format("%s e' finito su %s e ha pagato %s a %s",
				player.getName(), property.getName(), property.getCost().getFormattedValue(), owner.getName());
	}
	
	/**
	 * 
	 * @return the player has paid for the property
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * 
	 * @return the owner of property
	 */
	public Player getOwner() {
		return owner;
	}

	/**
	 * 
	 * @return the property
	 */
	public Property getProperty() {
		return property;
	}
}
