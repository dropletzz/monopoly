package monopoly.events;

import monopoly.Capital;

public class PlayerOutOfPrison implements Event {
	
	private double tax;
	
	public PlayerOutOfPrison(double tax) {
		this.tax = tax;
	}

	@Override
	public String getMessage() {
		return String.format("paghi %s per uscire di prigione", Capital.format(tax));
	}
}