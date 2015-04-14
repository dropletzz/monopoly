package monopoly.cards;

import monopoly.Player;
import monopoly.Players;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class Move extends Card {
	
	private int distance;
	/**
	 * Constructor of Move class
	 * @param distance the distance from the current slot
	 * @param text the text
	 */
	public Move(int distance, String text) {
		super(text);
		this.distance = distance;
	}

	/**
	 * 
	 * @param ps the players who must move
	 * @param result 
	 */
	@Override
	public void effect(Players ps, int result) {
		Player p = ps.current();
		if (distance >= 0)
			p.move(distance);
		else
			p.moveBack(-distance);
		
		p.getSlot().action(ps, distance);
	}
}