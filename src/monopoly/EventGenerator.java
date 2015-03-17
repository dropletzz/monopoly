package monopoly;


/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 * @param <T>
 *
 */
public abstract class EventGenerator {

	private Game observer;
	
	/**
	 * 
	 * @param o add to the list of observers
	 */
	public void setObserver(Game o) {
		observer = o;
	}
	
	protected Game getObserver() {
		return observer;
	}
}
