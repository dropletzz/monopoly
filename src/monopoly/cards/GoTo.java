package monopoly.cards;

import monopoly.Players;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class GoTo extends Card {
	
	private int destination;
	
	/**
	 * Constructor of GoTo class
	 * @param destination the destination slot
	 * @param text the text
	 */
	public GoTo(int destination, String text) {
		super(text);
		this.destination = destination;
	}

	/**
	 * 
	 * @param players the players who must move
	 * @param result the dice roll
	 */
	@Override
	public void thisEffect(Players players, int result) {
		players.current().moveTo(destination);
		players.current().getSlot().action(players, result);
	}
}