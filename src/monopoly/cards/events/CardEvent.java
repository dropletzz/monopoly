package monopoly.cards.events;

import monopoly.Event;
import monopoly.cards.Card;
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