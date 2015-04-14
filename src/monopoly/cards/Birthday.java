package monopoly.cards;

import monopoly.Player;
import monopoly.Players;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class Birthday extends Card {

	private double amount;

	/**
	 * Constructor of Birthday class
	 * @param amount the amount each players give
	 * @param text the text
	 */
	public Birthday(double amount, String text) {
		super(text);
		this.amount = amount;
	}

	/**
	 * 
	 * @param ps the players who celebrate birthday
	 * @param result 
	 */
	@Override
	public void effect(Players ps, int result) {
		for (Player p:ps.others()) {
			p.withdrawMoney(amount);
			ps.current().addMoney(amount);
		}
	}
}