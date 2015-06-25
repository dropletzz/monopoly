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
	 * @param players the players who celebrate birthday
	 * @param result 
	 */
	@Override
	public void thisEffect(Players players, int result) {
		for (Player p:players.others()) {
			p.withdrawMoney(amount);
			players.current().addMoney(amount);
		}
	}
}