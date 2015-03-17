package monopoly.events;

import monopoly.Capital;
import monopoly.Player;
import monopoly.slots.Property;

public class PlayerPaidForProperty implements Event {
	
	private Player owner;
	private Property property;
	private double amount;
	
	public PlayerPaidForProperty(Player owner, Property property, double amount) {
		this.amount = amount;
		this.owner = owner;
		this.property = property;
	}

	public String getMessage() {
		return String.format("sei finito su %s e hai pagato %s a %s",
				property.getName(), Capital.format(amount), owner.getName());
	}

	public Player getOwner() {
		return owner;
	}

	public Property getProperty() {
		return property;
	}
}