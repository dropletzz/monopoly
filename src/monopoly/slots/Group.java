package monopoly.slots;

public class Group {
	
	private Property[] properties;
	
	public Group(Property... properties) {
		this.properties = properties;
		for (Property p:properties)
			p.setGroup(this);
	}
	
	public Property[] getProperties() {
		return properties;
	}

}
