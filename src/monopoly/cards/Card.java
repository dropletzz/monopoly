package monopoly.cards;

import monopoly.Players;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public abstract class Card {
	
	private String text;
	
	/**
	 * Constructor of Card class
	 * @param text the text
	 */
	public Card(String text) {
		this.text = text;
	}
	
	/**
	 * active the effect of the card
	 * @param ps 
	 * @param result 
	 */
	public abstract void effect(Players ps, int result);
	
	/**
	 * 
	 * @return the text
	 */
	public String toString() {
		return text;
	}
}