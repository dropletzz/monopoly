package monopoly.slots;

import monopoly.Player;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class Terrain extends Property {
	
	private static final double PERCENTAGE =  0.1;
	private static final int GROUP_MULTIPLIER =  4;

	/**
	 * Constructor of Station class
	 * @param name the name of the slot
	 * @param value the value of the slot
	 */
	public Terrain(String name, double value) {
		super(name, value);
	}
	
	/**
	 * 
	 * @param owner the owner of the slot
	 * @param d the dice 
	 * @return the amount to be paid
	 */
	protected double calculateAmount(Player owner, int result) {
		int mult = 1;
		if (getGroup() != null && owner.owns(getGroup()))
			mult = GROUP_MULTIPLIER;
		return PERCENTAGE * getValue() * mult;
	}
}
