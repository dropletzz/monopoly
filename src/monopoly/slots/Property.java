package monopoly.slots;

import monopoly.Capital;
import monopoly.Dice;
import monopoly.Player;
import monopoly.PlayerBoughtProperty;
import monopoly.PlayerPaidForProperty;
import monopoly.Players;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public abstract class Property extends Slot {

	private Capital cost;
	private Group group;
	/**
	 * Constructor of Property class
	 * @param name the name of the slot
	 * @param value the value of the slot
	 */
	public Property(String name, double value) {
		super(name);
		this.cost =  new Capital(value);
	}
	
	protected abstract double calculateAmount(Player owner, Dice d);
	
	/**
	 * the action of the slot
	 */
	@Override
	public void action(Players ps, Dice d) {
		Player owner = ps.ownerOf(this);
		Player current = ps.current();
		if (owner == null) {
			if (current.canBuy(this)) {
				current.withdrawMoney(cost);
				current.addProperty(this);
				notice(new PlayerBoughtProperty(current, this));
			}
		}
		else
			if (!owner.equals(current)) {
				double amt = calculateAmount(owner, d);
				current.withdrawMoney(amt);
				owner.addMoney(amt);
				notice(new PlayerPaidForProperty(current, owner, this));
			}
	}
	
	/**
	 * 
	 * @return the Capital of the slot
	 */
	public Capital getCost() {
		return cost;
	}
	
	/**
	 * 
	 * @return the value of the slot
	 */
	public double getValue() {
		return cost.getValue();
	}
	
	/**
	 * 
	 * @return the Group
	 */
	public Group getGroup() {
		return group;
	}

	/**
	 * 
	 * @param group set group as Group of the slot
	 */
	public void setGroup(Group group) {
		this.group = group;
	}

}
