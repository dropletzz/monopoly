package monopoly.slots;

import monopoly.Capital;
import monopoly.Dice;
import monopoly.Player;
import monopoly.Players;

public abstract class Property extends Slot {

	private Capital cost;
	private Group group;
	
	public Property(String name, double value) {
		super(name);
		this.cost =  new Capital(value);
	}
	
	protected abstract double calculateAmount(Player owner, Dice d);
	
	@Override
	public void action(Players ps, Dice d) {
		Player owner = ps.ownerOf(this);
		Player current = ps.current();
		if (owner == null) {
			current.withdrawMoney(cost);
			current.addProperty(this);
		}
		else
			if (!owner.equals(current)) {
				double amt = calculateAmount(owner, d);
				current.withdrawMoney(amt);
				owner.addMoney(amt);
			}
	}
	
	public Capital getCost() {
		return cost;
	}
	
	public double getValue() {
		return cost.getValue();
	}
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}
