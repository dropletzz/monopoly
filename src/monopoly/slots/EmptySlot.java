package monopoly.slots;

import monopoly.Players;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public final class EmptySlot extends Slot {

	/**
	 * Constructor of EmptySlot class
	 */
	public EmptySlot() {
		super("");
	}
	
	/**
	 * 
	 * @param name the name of the slot
	 */
	public EmptySlot(String name) {
		super(name);
	}
	
	/**
	 * 
	 * @param p Players must make an action
	 * @param result the dice roll
	 */
	@Override
	public void action(Players p, int result) {}

}
