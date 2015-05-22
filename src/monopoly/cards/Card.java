package monopoly.cards;

import monopoly.Players;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public abstract class Card {
	
	private Card card;
	
	private String text;
	
	/**
	 * Constructor of Card class
	 * @param text the text
	 */
	public Card(String text) {
		this.text = text;
	}
	
	/**
	 * Constructor of Card class composed with another card
	 * @param text the text
	 */
	public Card(String text, Card card) {
		this.text = text;
		this.card = card;
	}
	
	/**
	 * active the effect of this particular card
	 * @param ps 
	 * @param result 
	 */
	protected abstract void thisEffect(Players ps, int result);
	
	/**
	 * active the effect of the card, including the ones that compose it
	 * @param ps 
	 * @param result 
	 */
	public void effect(Players ps, int result) {
		thisEffect(ps, result);
		if (card != null)
			card.effect(ps, result);
	}
	
	/**
	 * 
	 * @return the text
	 */
	public String toString() {
		if (card == null)
			return text;
		else 
			return text + "\n" + card.toString();
	}
	
	public Card compose(Card card) {
		this.card = card;
		return this;
	}
}