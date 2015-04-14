package monopoly.cards;

import monopoly.Players;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class AddMoney extends Card {

	private double amount;
	
	/**
	 * Constructor of AddMoney class
	 * @param amount the amount earned
	 * @param text the text
	 */
	public AddMoney(double amount, String text) {
		super(text);
		this.amount = amount;
	}

	/**
	 * 
	 * @param ps the players who must earn
	 * @param result 
	 */
	@Override
	public void effect(Players ps, int result) {
		ps.current().addMoney(amount);
	}
}