package monopoly.slots.events;

import monopoly.Event;
import monopoly.slots.Property;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class PlayerBoughtProperty implements Event {
	
	private Property property;

	/**
	 * Constructor of PlayerBoughtProperty class
	 * @param property
	 */
	public PlayerBoughtProperty(Property property) {
		this.property = property;
	}

	/**
	 * 
	 * @return the message of the event to bought the property
	 */
	public String getMessage() {
		return String.format("hai comprato %s pagandola %s", property.getName(), property.getCost().getFormattedValue());
	}

	/**
	 * 
	 * @return the property that has been bought
	 */
	public Property getProperty() {
		return property;
	}
}