package monopoly.slots;

import monopoly.EventGenerator;
import monopoly.Players;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public abstract class Slot extends EventGenerator {
	
	private String name;
	
	/**
	 * Constructor of Slot class
	 * @param name the name of the slot
	 */
	public Slot (String name) {	
		super();
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
	 * @param ps Players must make an action
	 * @param result the result of the dice roll
	 */
	public abstract void action(Players ps, int result);
	
	/**
	 * 
	 * @param o the slot to be checked
	 * @return true if the slots are equal
	 */
	public boolean equals(Object o) {
		if (o instanceof Slot)
			return this.equals((Slot) o);
		else
			return false;
	}
	
	/**
	 * 
	 * @param p the slot to be checked
	 * @return true if they have the same name
	 */
	public boolean equals(Slot p) {
		return p.getName().equals(this.getName());
	}
}
