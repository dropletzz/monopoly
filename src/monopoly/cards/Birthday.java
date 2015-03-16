package monopoly.cards;

import monopoly.Player;
import monopoly.Players;

public class Birthday extends Card {

	private double amount;
	
	public Birthday(double amount, String text) {
		super(text);
		this.amount = amount;
	}

	@Override
	public void effect(Players ps, int result) {
		for (Player p:ps.others()) {
			p.withdrawMoney(amount);
			ps.current().addMoney(amount);
		}
	}
}