package monopoly.cards;

import monopoly.Players;

public class GoTo implements Card {
	
	private int destination;
	
	public GoTo(int destination) {
		this.destination = destination;
	}

	@Override
	public void effect(Players ps) {
		ps.current().moveTo(destination);
	}
}