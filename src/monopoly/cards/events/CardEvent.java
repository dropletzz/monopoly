package monopoly.cards.events;

import monopoly.cards.Card;
import monopoly.events.Event;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class CardEvent implements Event {
	
	private Card card;

	/**
	 * Constructor of Card class
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