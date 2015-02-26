package monopoly;

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
	public ToPrison(int prisonPosition) {
		super("IN PRIGIONE!");
		this.prisonPosition = prisonPosition;
	}

	/**
	 * 
	 * @param ps Players that have to go to the prison
	 */
	@Override
	public void action(Players ps) {
		Player p = ps.current();
		p.setPosition(prisonPosition);
	}
}