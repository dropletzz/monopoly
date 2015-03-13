package monopoly.cards;

import monopoly.Players;

public class GoToNoStartBonus implements Card {
	private int destination;
	
	public GoToNoStartBonus(int destination) {
		this.destination = destination;
	}

	@Override
	public void effect(Players ps) {
		ps.current().setPosition(destination);
	}
}