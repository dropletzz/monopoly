package monopoly.cards;

import monopoly.Players;

public class GoToNoStartBonus extends Card {
	private int destination;
	
	public GoToNoStartBonus(int destination, String text) {
		super(text);
		this.destination = destination;
	}

	@Override
	public void effect(Players ps, int result) {
		ps.current().setPosition(destination);
		ps.current().getSlot().action(ps, result);
	}
}