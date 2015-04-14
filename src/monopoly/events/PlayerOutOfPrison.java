package monopoly.events;

import monopoly.Capital;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class PlayerOutOfPrison implements Event {
	
	private double tax;
	
	/**
	 * Constructor of PlayerOutOfPrison class
	 * @param tax
	 */
	public PlayerOutOfPrison(double tax) {
		this.tax = tax;
	}

	/**
	 * 
	 * @return the message of the event to exit to prison
	 */
	@Override
	public String getMessage() {
		return String.format("paghi %s per uscire di prigione", Capital.format(tax));
	}
}