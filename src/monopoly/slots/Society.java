package monopoly.slots;

import monopoly.Dice;
import monopoly.Player;

public class Society extends Property {
	
	private static final int MULTIPLIER = 4;
	private static final int GROUP_MULTIPLIER = 10;

	public Society(String name, double value) {
		super(name, value);
	}

	@Override
	protected double calculateAmount(Player owner, Dice d) {
		int mult;
		if (getGroup() != null && owner.owns(getGroup()))
			mult = GROUP_MULTIPLIER;
		else
			mult = MULTIPLIER;
			
		return d.result() * mult;
	}
}
