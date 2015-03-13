package monopoly.cards;

import monopoly.Board;
import monopoly.Players;

public class Move implements Card {
	
	private int distance;
	
	public Move(int distance, Board board) {
		this.distance = distance;
	}

	@Override
	public void effect(Players ps) {
		if (distance >= 0)
			ps.current().move(distance);
		else
			ps.current().moveBack(-distance);
	}
}