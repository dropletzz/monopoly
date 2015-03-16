package monopoly.slots;

import monopoly.Players;
import monopoly.cards.Card;
import monopoly.cards.Deck;
import monopoly.cards.DecksConstructor;
import monopoly.events.CardEvent;

public class Chance extends Slot {
	
	private static Deck CHANCE_CARDS = DecksConstructor.chancesDeck();

	public Chance() {
		super("PROBABILITA'");
	}

	@Override
	public void action(Players ps, int result) {
		Card card = CHANCE_CARDS.nextCard();
		notice(new CardEvent(card));
		card.effect(ps, result);
	}
}