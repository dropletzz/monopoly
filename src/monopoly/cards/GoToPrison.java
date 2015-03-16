package monopoly.cards;

import monopoly.Players;

public class GoToPrison extends GoToNoStartBonus {

	public GoToPrison(int destination, String text) {
		super(destination, text);
	}
	
	public void effect(Players ps, int result) {
		super.effect(ps, result);
		ps.current().imprison();
	}
}