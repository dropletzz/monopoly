package monopoly.cards;

import monopoly.Player;
import monopoly.Players;

public class Move extends Card {
	
	private int distance;
	
	public Move(int distance, String text) {
		super(text);
		this.distance = distance;
	}

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