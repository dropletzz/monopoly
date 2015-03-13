package monopoly.slots;

import monopoly.Dice;
import monopoly.Players;
import monopoly.cards.Deck;

public class Chance extends Slot {
	
	private static Deck CHANCE_CARDS;

	public Chance() {
		super("PROBABILITA'");
	}

	@Override
	public void action(Players p, Dice d) {
	}
}
