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
public class Accident extends Slot {

	private static Deck ACCIDENT_CARDS = DecksConstructor.accidentsDeck();
	
	/**
	 * Constructor of Accident class
	 */
	public Accident() {
		super("IMPREVISTO");
	}

	/**
	 * 
	 * @param ps Players must make an accident
	 * @param result the result of the dice roll
	 */
	@Override
	public void action(Players ps, int result) {
		Card card = ACCIDENT_CARDS.nextCard();
		notice(new CardEvent(card));
		card.effect(ps, result);	
	}
}