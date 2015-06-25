package monopoly.cards;

import monopoly.Players;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class GoToNoStartBonus extends Card {
	private int destination;
	
	/**
	 * Constructor of GoToNoStartBonus class
	 * @param destination the destination slot
	 * @param text the text
	 */
	public GoToNoStartBonus(int destination, String text) {
		super(text);
		this.destination = destination;
	}

	/**
	 * if the player pass by start don't receive the bonus
	 * @param players the players who must move
	 * @param result the dice roll
	 */
	@Override
	public void thisEffect(Players players, int result) {
		players.current().setPosition(destination);
		players.current().getSlot().action(players, result);
	}
}