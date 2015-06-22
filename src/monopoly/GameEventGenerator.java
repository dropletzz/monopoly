package monopoly;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public abstract class GameEventGenerator {

	private Game game;
	
	/**
	 * 
	 * @param o add to the list of observers
	 */
	public void setGame(Game o) {
		game = o;
	}
	
	/**
	 * 
	 * @return the observer
	 */
	protected Game getGame() {
		return game;
	}
}
