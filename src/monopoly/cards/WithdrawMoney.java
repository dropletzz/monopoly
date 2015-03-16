package monopoly.cards;

import monopoly.Players;

public class WithdrawMoney extends Card {
	
	private double amount;
	
	public WithdrawMoney(double amount, String text) {
		super(text);
		this.amount = amount;
	}

	@Override
	public void effect(Players ps, int result) {
		ps.current().withdrawMoney(amount);
	}
}