package monopoly.slots;

import monopoly.Players;
import monopoly.cards.Card;
import monopoly.cards.Deck;
import monopoly.cards.events.CardEvent;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class Chance extends Slot {
	
	private static Deck CHANCE_CARDS;

	/**
	 * Constructor of Chance class
	 */
	public Chance() {
		super("PROBABILITA'");
	}

	/**
	 * 
	 * @param players Players must make an chance
	 * @param result the result of the dice roll
	 */
	@Override
	public void action(Players players, int result) {
		Card card = CHANCE_CARDS.nextCard();
		getGame().handleEvent(new CardEvent(card));
		card.effect(players, result);
	}	
	
	/**
	 * 
	 * @param deck set the deck d
	 */
	public static void setDeck(Deck deck) {
		CHANCE_CARDS = deck;
	}
}