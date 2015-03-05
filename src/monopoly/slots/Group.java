package monopoly.slots;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class Group {
	
	private Property[] properties;
	/**
	 * Constructor of EmptySlot class
	 * @param properties the properties of the group
	 */
	public Group(Property... properties) {
		this.properties = properties;
		for (Property p:properties)
			p.setGroup(this);
	}
	
	/**
	 * 
	 * @return the array of properties in the group
	 */
	public Property[] getProperties() {
		return properties;
	}

}
