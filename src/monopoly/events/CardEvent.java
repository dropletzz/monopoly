package monopoly.events;

import monopoly.cards.Card;
import monopoly.event_handlers.Event;

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