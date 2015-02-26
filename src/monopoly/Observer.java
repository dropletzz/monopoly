package monopoly;
/**
 * 
 * @author Donatello Rovizzi & Giovanni Caniato
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
