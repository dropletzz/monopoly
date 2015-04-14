package monopoly;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public final class Board {
	
	final private Slot slots [];
	final private int dimension;
	final private int prison;
	
	/**
	 * Constructor of Board class
	 * @param dimension of the board
	 * @param prison the slot of the prison 
	 */
	public Board(int dimension, int prison) {
		assert dimension > 0 : "the board hasn't slots!"; 
		this.dimension = dimension;
		this.slots = new Slot [dimension];
		this.prison = prison;
	}
	
	/**
	 * 
	 * @param index the index of the slot 
	 * @return the slot at the position of the index
	 */
	public Slot getSlot (int index) {
		assert index > 0 : "index can't be negative" + index;
		return slots[index];
	}
	
	/**
	 * 
	 * @param s the slot to add
	 * @param position the position of the slot
	 */
	public void addSlot(Slot s, int position) {
		assert position > 0 : "position can't be negative" + position;
		slots[position] = s;
	}
	
	/**
	 * 
	 * @param p Players involved in the action
	 */
	public void action(Players p) {
		slots[p.current().getPosition()].action(p);
	}

	
	/**
	 * 
	 * @param p the palyer who is moved
	 * @param result the player moves forward of result
	 */
	public void move(Player p, int result) {
		p.setPosition((p.getPosition() + result) % dimension);
	}
        
	/**
	 * 
	 * @param p the player who must go to the prison
	 */
    public void moveToPrison(Player p) {
	p.setPosition(prison);
	}

    /**
     * 
     * @return the position of the prison
     */
	public int getPrisonPosition() {
		return prison;
	}
}
