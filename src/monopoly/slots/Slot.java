package monopoly.slots;

import monopoly.Dice;
import monopoly.Players;
import monopoly.event_handlers.EventGenerator;
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
	 * @param p Players must make an action
	 * @param d the dice 
	 */
	public abstract void action(Players p, Dice d);
	
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