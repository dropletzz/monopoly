package monopoly.slots;

import monopoly.Players;
import monopoly.cards.Card;
import monopoly.cards.Deck;
import monopoly.events.CardEvent;

public class Chance extends Slot {
	
	private static Deck CHANCE_CARDS;

	public Chance() {
		super("PROBABILITA'");
	}

	@Override
	public void action(Players ps, int result) {
		Card card = CHANCE_CARDS.nextCard();
		getObserver().handleEvent(new CardEvent(card));
		card.effect(ps, result);
	}	
	
	public static void setDeck(Deck d) {
		CHANCE_CARDS = d;
	}
}