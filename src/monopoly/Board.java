package monopoly;

import monopoly.slots.*;

/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public final class Board {
	


	final private Slot slots [];
	final private int prison;
	private double startBonus;
	
	/**
	 * Constructor of Board class
	 * @param dimension of the board
	 * @param prison the slot of the prison
	 * @param startBonus bonus if start slot is active 
	 */
	public Board(int dimension, int prison, double startBonus) {
		assert dimension > 0 : "the board hasn't slots!"; 
		this.slots = new Slot [dimension];
		this.prison = prison;
		this.startBonus = startBonus;
	}
	
	/**
	 * 
	 * @param index the index of the slot 
	 * @return the slot at the position of the index
	 */
	public Slot getSlot (int index) {
		assert index >= 0 : "index can't be negative";
		return slots[index];
	}
	
	/**
	 * 
	 * @param s the slot to add
	 * @param position the position of the slot
	 */
	public void addSlot(Slot s, int position) {
		assert position >= 0 : "position can't be negative";
		slots[position] = s;
	}
	
	/**
	 * 
	 * @param players Players involved in the action
	 * @param result the result of the dice roll
	 */
	public void action(Players players, int result) {
		slots[players.current().getPosition()].action(players, result);
	}

    /**
     * 
     * @return the position of the prison
     */
	public int getPrisonPosition() {
		return prison;
	}
	
	/**
	 *
	 * @param game the observer to add
	 */
	public void setGame(Game game) {
		for (Slot s:slots) {
			s.setGame(game);
		}
	}
	
	/**
	 * 
	 * @param index the index of the property
	 * @return the property at the passed index
	 */
	public Property getProperty(int index) {
		assert index >= 0 : "index can't be negative";
		if (slots[index] instanceof Property)
			return (Property) slots[index];
		return null;
	}
	
	/**
	 * 
	 * @return the number of slots
	 */
	public int size() {
		return slots.length;
	}
	
	/**
	 * 
	 * @return the start bonus
	 */
	public double getStartBonus() {
		return startBonus;
	}
}
