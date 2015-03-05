package monopoly;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public interface Observer {
	/**
	 * 
	 * @param message 
	 */
	public void update(String message);
	
	/**
	 * 
	 */
	public void update();
}
