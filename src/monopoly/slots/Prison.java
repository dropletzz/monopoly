package monopoly.slots;

import monopoly.Dice;
import monopoly.Players;


/**
 * 
 * @author Donatello Rovizzi & Giovanni Caniato
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
	 */
	@Override
	public void action(Players ps, Dice d) {}

}
