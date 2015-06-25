package monopoly.slots;

import monopoly.Player;
import monopoly.Players;
import monopoly.events.PlayerToPrison;
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
	 * @param players Players that have to go to the prison
	 * @param result 
	 */
	@Override
	public void action(Players players, int result) {
		Player p = players.current();
		p.setPosition(prisonPosition);
		p.imprison();
		getGame().handleEvent(new PlayerToPrison());
	}
}