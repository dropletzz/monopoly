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
	 * @param players 
	 * @param result 
	 */
	protected abstract void thisEffect(Players players, int result);
	
	/**
	 * active the effect of the card, including the ones that compose it
	 * @param players 
	 * @param result 
	 */
	public void effect(Players players, int result) {
		thisEffect(players, result);
		if (card != null)
			card.effect(players, result);
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
	
	/**
	 * 
	 * @param card the card to be composed with another card
	 * @return the card composed
	 */
	public Card compose(Card card) {
		this.card = card;
		return this;
	}
}