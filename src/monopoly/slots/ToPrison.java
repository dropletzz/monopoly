package monopoly.slots;

import monopoly.Dice;
import monopoly.Observer;
import monopoly.Player;
import monopoly.Players;


/**
 * 
 * @author Donatello Rovizzi & Giovanni Caniato
 *
 */
public class ToPrison extends Slot {
	private int prisonPosition;

	/**
	 * Constructor of ToPrison class
	 * @param prisonPosition the initial position of this slot
	 */
	public ToPrison(int prisonPosition, Observer o) {
		super("Vai in prigione");
		this.prisonPosition = prisonPosition;
		this.addObserver(o);
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