package monopoly.events;

import monopoly.slots.Property;

public class PlayerBoughtProperty implements Event {
	
	private Property property;
	
	public PlayerBoughtProperty(Property property) {
		this.property = property;
	}

	public String getMessage() {
		return String.format("hai comprato %s pagandola %s", property.getName(), property.getCost().getFormattedValue());
	}

	public Property getProperty() {
		return property;
	}
}