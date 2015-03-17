package monopoly.events;

import monopoly.Capital;
import monopoly.slots.Tax;

public class PlayerPaidTax implements Event {
	
	private Tax t;
	
	public PlayerPaidTax(Tax t) {
		this.t = t;
	}

	@Override
	public String getMessage() {
		return String.format("%s: paga %s", t.getName(), Capital.format(t.getAmount()));
	}
}