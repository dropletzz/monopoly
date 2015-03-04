package monopoly.slots;

import monopoly.Dice;
import monopoly.Player;

public class Station extends Property {

	private static final double PERCENTAGE =  0.1;
	
	public Station(String name, double value) {
		super(name, value);
	}

	@Override
	protected double calculateAmount(Player owner, Dice d) {
		return PERCENTAGE * getValue();
	}
}