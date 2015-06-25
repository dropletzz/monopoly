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
	 * @param game add to the list of observers
	 */
	public void setGame(Game game) {
		this.game = game;
	}
	
	/**
	 * 
	 * @return the observer
	 */
	protected Game getGame() {
		return game;
	}
}
