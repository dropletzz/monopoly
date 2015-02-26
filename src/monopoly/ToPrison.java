package monopoly;

public class ToPrison extends Slot {
	private int prisonPosition;

	public ToPrison(int prisonPosition) {
		super("IN PRIGIONE!");
		this.prisonPosition = prisonPosition;
	}

	@Override
	public void action(Players ps) {
		Player p = ps.current();
		p.setPosition(prisonPosition);
	}
}