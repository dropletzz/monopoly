package monopoly.cards;

import monopoly.Players;

public class AddMoney implements Card {

	private double amount;
	
	public AddMoney(double amount) {
		this.amount = amount;
	}

	@Override
	public void effect(Players ps) {
		ps.current().addMoney(amount);
	}
}