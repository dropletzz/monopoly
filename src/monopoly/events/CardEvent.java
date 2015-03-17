package monopoly.events;

import monopoly.cards.Card;

public class CardEvent implements Event {
	
	private Card card;

	public CardEvent(Card card) {
		this.card = card;
	}
	
	@Override
	public String getMessage() {
		return card.toString();
	}
}