package monopoly.cards;

import monopoly.Players;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class GoToPrison extends GoToNoStartBonus {

	/**
	 * Constructor of GoToPrison class
	 * @param destination the destination slot
	 * @param text the text
	 */
	public GoToPrison(int destination, String text) {
		super(destination, text);
	}
	
	/**
	 * 
	 * @param ps the players who must move to prison
	 * @param result the dice roll
	 */
	public void effect(Players ps, int result) {
		super.effect(ps, result);
		ps.current().imprison();
	}
}