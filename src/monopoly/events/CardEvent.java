package monopoly.events;

import monopoly.cards.Card;
import monopoly.event_handlers.Event;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class CardEvent implements Event {
	
	private Card card;

	/**
	 * Constructor of CardEvent class
	 * @param card 
	 */
	public CardEvent(Card card) {
		this.card = card;
	}
	
	/**
	 * 
	 * @return the text of the card
	 */
	@Override
	public String getMessage() {
		return card.toString();
	}
}