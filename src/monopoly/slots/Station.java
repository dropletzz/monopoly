package monopoly.slots;

import monopoly.Player;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class Station extends Property {

	private static final double PERCENTAGE =  0.1;
	
	/**
	 * Constructor of Station class
	 * @param name the name of the slot
	 * @param value the value of the slot
	 */
	public Station(String name, double value) {
		super(name, value);
	}

	/**
	 * 
	 * @param owner the owner of the slot
	 * @param result of the dice roll
	 * @return the amount to be paid
	 */
	@Override
	protected double calculateAmount(Player owner, int result) {
		return PERCENTAGE * getValue();
	}
}