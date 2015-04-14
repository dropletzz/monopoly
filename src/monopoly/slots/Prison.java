package monopoly.slots;

import monopoly.Players;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public final class Prison extends Slot {

	/**
	 * Constructor of Prison class
	 * @param name the name of slot
	 */
	public Prison(String name) {
		super(name);
	}
	
	/**
	 * 
	 * @param ps Players must go to prison
	 * @param result the dice roll
	 */
	@Override
	public void action(Players ps, int result) {}

}
