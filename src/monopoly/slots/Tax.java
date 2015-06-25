package monopoly.slots;

import monopoly.Players;
import monopoly.slots.events.PlayerPaidTax;
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
	 * @param players Players who have to paid
	 * @param result the dice roll
	 */
	@Override
	public void action(Players players, int result) {
		players.current().withdrawMoney(amount);
		getGame().handleEvent(new PlayerPaidTax(this));
	}

	/**
	 * 
	 * @return amount to be paid
	 */
	public double getAmount() {
		return amount;
	}
}