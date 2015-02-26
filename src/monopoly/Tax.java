package monopoly;
/**
 * 
 * @author Donatello Rovizzi & Giovanni Caniato
 *
 */
public class Tax extends Slot {
	private double amount;

	/**
	 * Constructor of Slot class
	 * @param name the name of the slot
	 * @param amount the amount to be paid
	 */
	public Tax(String name, double amount) {
		super(name);
		this.amount = amount;
	}

	/**
	 * 
	 * @param amount Players who hace to paid
	 */
	@Override
	public void action(Players p) {
		p.current().withdrawMoney(amount);
	}

}