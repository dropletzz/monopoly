package monopoly.slots;



import monopoly.Dice;
import monopoly.Player;

public class Terrain extends Property {
	
	private static final double PERCENTAGE =  0.1;
	private static final int GROUP_MULTIPLIER =  4;

	public Terrain(String name, double value) {
		super(name, value);
	}
	
	protected double calculateAmount(Player owner, Dice d) {
		int mult = 1;
		if (getGroup() != null && owner.owns(getGroup()))
			mult = GROUP_MULTIPLIER;
		return PERCENTAGE * getValue() * mult;
	}
}
