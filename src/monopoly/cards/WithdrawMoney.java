package monopoly.cards;

import monopoly.Players;

public class WithdrawMoney implements Card {
	
	private double amount;
	
	public WithdrawMoney(double amount) {
		this.amount = amount;
	}

	@Override
	public void effect(Players ps) {
		ps.current().withdrawMoney(amount);
	}
}