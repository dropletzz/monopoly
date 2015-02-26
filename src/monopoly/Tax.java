package monopoly;

public class Tax extends Slot {
	private double amount;

	public Tax(String name, double amount) {
		super(name);
		this.amount = amount;
	}

	@Override
	public void action(Players p) {
		p.current().withdrawMoney(amount);
	}

}