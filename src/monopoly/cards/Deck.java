package monopoly.cards;

import java.util.Collections;
import java.util.Vector;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class Deck {

	private Vector<Card> cards;
	private Vector<Card> usedCards;
	
	/**
	 * Constructor of Deck class
	 */
	public Deck() {
		cards = new Vector<Card>();
		usedCards = new Vector<Card>();
	}
	
	/**
	 * 
	 * @param c card to be added
	 */
	public void addCard(Card c) {
		cards.add(c);
	}
	
	/**
	 * 
	 * @return the next card
	 */
	public Card nextCard() {
		if (cards.size() == 0) {
			Vector<Card> tmp = cards;
			cards = usedCards;
			usedCards = tmp;
			shuffle();
		}

		usedCards.add(cards.elementAt(0));
		return cards.remove(0);
	}
	
	/**
	 * shuffle the deck
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}
}