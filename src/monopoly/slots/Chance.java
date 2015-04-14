package monopoly.slots;

import monopoly.Players;
import monopoly.cards.Card;
import monopoly.cards.Deck;
import monopoly.cards.DecksConstructor;
import monopoly.events.CardEvent;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class Chance extends Slot {
	
	private static Deck CHANCE_CARDS = DecksConstructor.chancesDeck();

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
		notice(new CardEvent(card));
		card.effect(ps, result);
	}
}