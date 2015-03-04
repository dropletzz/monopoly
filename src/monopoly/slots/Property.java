package monopoly.slots;



import monopoly.Dice;
import monopoly.Player;
import monopoly.Players;

public class Property extends Slot {
	
	private static final double PERCENTAGE =  0.1;
	private static final int GROUP_MULTIPLIER =  4;
	private double value;
	private Group group;

	public Property(String name, double value) {
		super(name);
		this.value = value;
	}

	@Override
	public void action(Players ps, Dice d) {
		Player owner = ps.ownerOf(this);
		Player current = ps.current();
		if (owner == null) {
			current.withdrawMoney(value);
			current.addProperty(this);
		}
		else
			if (!owner.equals(current)) {
				double amt = calculateAmount(owner);
				current.withdrawMoney(amt);
				owner.addMoney(amt);
			}		
	}
	
	private double calculateAmount(Player owner) {
		if (owner.owns(this.group))
			return PERCENTAGE * value * GROUP_MULTIPLIER;
		else
			return PERCENTAGE * value;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	

}
