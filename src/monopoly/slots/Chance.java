package monopoly.slots;

import monopoly.Players;
import monopoly.cards.Deck;
import monopoly.cards.DecksConstructor;

public class Chance extends Slot {
	
	private static Deck CHANCE_CARDS = DecksConstructor.chancesDeck();

	public Chance() {
		super("PROBABILITA'");
	}

	@Override
	public void action(Players ps, int result) {
		CHANCE_CARDS.nextCard().effect(ps);
	}
}
