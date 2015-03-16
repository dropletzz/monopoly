package monopoly.cards;

import monopoly.Players;

public class GoTo extends Card {
	
	private int destination;
	
	public GoTo(int destination, String text) {
		super(text);
		this.destination = destination;
	}

	@Override
	public void effect(Players ps, int result) {
		ps.current().moveTo(destination);
		ps.current().getSlot().action(ps, result);
	}
}