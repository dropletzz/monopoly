package monopoly.slots;

import monopoly.Players;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class Tax extends Slot {
	private double amount;

	/**
	 * Constructor of Slot class
	 * @param name the name of the slot
	 * @param amount the amount to be paid
	 */
	public Tax(String name, double amount) {
		super(name);
		this.amount = amount;
	}

	/**
	 * 
	 * @param amount Players who have to paid
	 */
	@Override
	public void action(Players ps, int result) {
		ps.current().withdrawMoney(amount);
	}

}