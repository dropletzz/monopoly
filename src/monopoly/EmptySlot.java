package monopoly;
/**
 * 
 * @author Donatello Rovizzi & Giovanni Caniato
 *
 */
public final class EmptySlot extends Slot {

	/**
	 * Constructor of EmptySlot class
	 */
	public EmptySlot() {
		super("");
	}
	
	/**
	 * 
	 * @param name the name of the slot
	 */
	public EmptySlot(String name) {
		super(name);
	}
	
	/**
	 * 
	 * @param p Players must make an action
	 */
	@Override
	public void action(Players p) {}

}
