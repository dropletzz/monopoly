package monopoly.slots.events;

import monopoly.Capital;
import monopoly.Event;
import monopoly.Player;
import monopoly.slots.Property;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class PlayerPaidForProperty implements Event {
	
	private Player owner;
	private Property property;
	private double amount;
	
	/**
	 * Constructor of PlayerPaidForProperty class
	 * @param owner
	 * @param property
	 * @param amount
	 */
	public PlayerPaidForProperty(Player owner, Property property, double amount) {
		this.amount = amount;
		this.owner = owner;
		this.property = property;
	}

	/**
	 * 
	 * @return the message of the event players paid other players
	 */
	public String getMessage() {
		return String.format("sei finito su %s e hai pagato %s a %s",
				property.getName(), Capital.format(amount), owner.getName());
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