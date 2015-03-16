package monopoly.cards;

import monopoly.Players;

public class AddMoney extends Card {

	private double amount;
	
	public AddMoney(double amount, String text) {
		super(text);
		this.amount = amount;
	}

	@Override
	public void effect(Players ps, int result) {
		ps.current().addMoney(amount);
	}
}