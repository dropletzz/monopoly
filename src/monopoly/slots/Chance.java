package monopoly.slots;

import monopoly.Players;
import monopoly.cards.Card;
import monopoly.cards.Deck;
import monopoly.events.CardEvent;
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
	 * @param ps Players must make an chance
	 * @param result the result of the dice roll
	 */
	@Override
	public void action(Players ps, int result) {
		Card card = CHANCE_CARDS.nextCard();
		getObserver().handleEvent(new CardEvent(card));
		card.effect(ps, result);
	}	
	
	/**
	 * 
	 * @param d set the deck d
	 */
	public static void setDeck(Deck d) {
		CHANCE_CARDS = d;
	}
}