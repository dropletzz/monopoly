package monopoly.slots;

import monopoly.Players;
import monopoly.cards.Card;
import monopoly.cards.Deck;
import monopoly.cards.DecksConstructor;
import monopoly.events.CardEvent;

public class Accident extends Slot {

	private static Deck ACCIDENT_CARDS = DecksConstructor.accidentsDeck();
	
	public Accident() {
		super("IMPREVISTO");
	}

	@Override
	public void action(Players ps, int result) {
		Card card = ACCIDENT_CARDS.nextCard();
		notice(new CardEvent(card));
		card.effect(ps, result);	
	}
}