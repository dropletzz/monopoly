package monopoly;

public abstract class Slot {
	
	private String name;
	
	public Slot (String name) {	
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void action(Players p);
}
