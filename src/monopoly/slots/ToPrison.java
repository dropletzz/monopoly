package monopoly.slots;

import monopoly.Dice;
import monopoly.Player;
import monopoly.Players;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class ToPrison extends Slot {
	private int prisonPosition;

	/**
	 * Constructor of ToPrison class
	 * @param prisonPosition the initial position of this slot
	 */
	public ToPrison(String name, int prisonPosition) {
		super(name);
		this.prisonPosition = prisonPosition;
	}

	/**
	 * 
	 * @param ps Players that have to go to the prison
	 */
	@Override
	public void action(Players ps, Dice d) {
		Player p = ps.current();
		p.setPosition(prisonPosition);
		notice("IN PRIGIONE!");
	}
}