package monopoly.slots;

import monopoly.Players;
import monopoly.cards.Deck;
import monopoly.cards.DecksConstructor;

public class Accident extends Slot {

	private static Deck ACCIDENT_CARDS = DecksConstructor.accidentsDeck();
	
	public Accident() {
		super("IMPREVISTO");
	}

	@Override
	public void action(Players ps, int result) {
		ACCIDENT_CARDS.nextCard().effect(ps);
	}
}
