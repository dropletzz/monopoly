package monopoly.cards;

import monopoly.Players;

public abstract class Card {
	
	private String text;
	
	public Card(String text) {
		this.text = text;
	}
	
	public abstract void effect(Players ps, int result);
	
	public String toString() {
		return text;
	}
}