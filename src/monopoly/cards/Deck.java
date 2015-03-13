package monopoly.cards;

import java.util.Collections;
import java.util.Vector;

public class Deck {

	private Vector<Card> cards;
	private Vector<Card> usedCards;
	
	public Deck() {
		cards = new Vector<Card>();
		usedCards = new Vector<Card>();
	}
	
	public void addCard(Card c) {
		cards.add(c);
	}
	
	public Card nextCard() {
		if (cards.size() == 0) {
			Vector<Card> tmp = cards;
			cards = usedCards;
			usedCards = tmp;
			Collections.shuffle(cards);
		}

		usedCards.add(cards.elementAt(0));
		return cards.remove(0);
	}
}