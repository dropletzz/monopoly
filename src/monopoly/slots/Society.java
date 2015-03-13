package monopoly.slots;

import monopoly.Player;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class Society extends Property {
	
	private static final int MULTIPLIER = 4;
	private static final int GROUP_MULTIPLIER = 10;
	/**
	 * Constructor of Society class
	 * @param name the name of the slot
	 * @param value the value of the slot
	 */
	public Society(String name, double value) {
		super(name, value);
	}

	/**
	 * 
	 * @param owner the owner of the slot
	 * @param d the dice 
	 * @return the amount to be paid
	 */
	@Override
	protected double calculateAmount(Player owner, int result) {
		int mult;
		if (getGroup() != null && owner.owns(getGroup()))
			mult = GROUP_MULTIPLIER;
		else
			mult = MULTIPLIER;
			
		return result * mult;
	}
}
