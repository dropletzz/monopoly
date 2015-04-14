package monopoly;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
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
	
	/**
	 * 
	 * @return the observer
	 */
	protected Game getObserver() {
		return observer;
	}
}
