package monopoly.slots.events;

import monopoly.Capital;
import monopoly.Event;
import monopoly.slots.Tax;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class PlayerPaidTax implements Event {
	
	private Tax t;
	
	/**
	 * Constructor of PlayerPaidTax class
	 * @param t the tax
	 */
	public PlayerPaidTax(Tax t) {
		this.t = t;
	}

	/**
	 * 
	 * @return the message of the event to pay tax
	 */
	@Override
	public String getMessage() {
		return String.format("%s: paga %s", t.getName(), Capital.format(t.getAmount()));
	}
}