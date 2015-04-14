package monopoly;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public abstract class Slot {
	
	private String name;
	
	/**
	 * Constructor of Slot class
	 * @param name the name of the slot
	 */
	public Slot (String name) {	
		this.name = name;
	}
	
	/**
	 * 
	 * @return the name of the slot
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param p Players must make an action
	 */
	public abstract void action(Players p);
}
