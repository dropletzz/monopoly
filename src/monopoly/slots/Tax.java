package monopoly.slots;

import monopoly.Dice;
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
	 * Constructor of Tax class
	 * @param name the name of the slot
	 * @param amount the amount to be paid
	 */
	public Tax(String name, double amount) {
		super(name);
		this.amount = amount;
	}

	/**
	 * 
	 * @param p Players who have to paid
	 * @param d the dice
	 */
	@Override
	public void action(Players p, Dice d) {
		p.current().withdrawMoney(amount);
	}

}