package monopoly.slots;

import monopoly.Players;
import monopoly.cards.Card;
import monopoly.cards.Deck;
import monopoly.events.CardEvent;

public class Accident extends Slot {

	private static Deck ACCIDENT_CARDS;
	
	public Accident() {
		super("IMPREVISTO");
	}

	@Override
	public void action(Players ps, int result) {
		Card card = ACCIDENT_CARDS.nextCard();
		getObserver().handleEvent(new CardEvent(card));
		card.effect(ps, result);
	}
	
	public static void setDeck(Deck d) {
		ACCIDENT_CARDS = d;
	}
}