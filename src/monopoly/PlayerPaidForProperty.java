package monopoly;

import monopoly.events.Event;
import monopoly.slots.Property;

public class PlayerPaidForProperty implements Event {
	
	private Player player;
	private Player owner;
	private Property property;
	
	public PlayerPaidForProperty(Player player, Player owner, Property property) {
		this.player = player;
		this.owner = owner;
		this.property = property;
	}

	public String getMessage() {
		return String.format("%s e' finito su %s e ha pagato %s a %s",
				player.getName(), property.getName(), property.getCost().getFormattedValue(), owner.getName());
	}
	
	public Player getPlayer() {
		return player;
	}

	public Player getOwner() {
		return owner;
	}

	public Property getProperty() {
		return property;
	}
}
