package monopoly;

import monopoly.slots.Slot;


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
	public void action(Players ps) {
		Player p = ps.current();
		p.setPosition(prisonPosition);
		notice("IN PRIGIONE!");
	}
}