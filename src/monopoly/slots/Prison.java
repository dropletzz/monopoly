package monopoly.slots;

import monopoly.Dice;
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
	 */
	public Prison(String name) {
		super(name);
	}
	
	/**
	 * 
	 * @param ps Players must go to prison
	 * @param d the dice
	 */
	@Override
	public void action(Players ps, Dice d) {}

}
