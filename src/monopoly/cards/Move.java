package monopoly.cards;

import monopoly.Board;
import monopoly.Player;
import monopoly.Players;

public class Move implements Card {
	
	private int distance;
	
	public Move(int distance, Board board) {
		this.distance = distance;
	}

	@Override
	public void effect(Players ps) {
		Player p = ps.current();
		if (distance >= 0)
			p.move(distance);
		else
			p.moveBack(-distance);
		
		p.getSlot().action(ps, distance);
	}
}