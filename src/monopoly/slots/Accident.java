package monopoly.slots;

import monopoly.Dice;
import monopoly.Players;
import monopoly.cards.Deck;

public class Accident extends Slot {

	private static Deck ACCIDENT_CARDS;
	
	public Accident() {
		super("IMPREVISTO");
	}

	@Override
	public void action(Players p, Dice d) {
	}
}
