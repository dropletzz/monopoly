package monopoly;

import monopoly.event_handlers.EventGenerator;
import monopoly.event_handlers.Observer;
import monopoly.events.PlayerBroke;
import monopoly.events.PlayerToPrison;
import monopoly.slots.*;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public final class Board extends EventGenerator {
	
	private static final int TURNS_TO_PRISON = 2;
	public static final String POSITION_MESSAGE = "Sei sulla casella %d";

	final private Slot slots [];
	final private int prison;
	private byte consecutiveTurns;
	private int turnsPlayed;
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
		this.consecutiveTurns = 0;
		this.turnsPlayed = 0;
		this.startBonus = startBonus;
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
	private void action(Players p, int result) {
		slots[p.current().getPosition()].action(p, result);
	}

	/**
	 * 
	 * @param ps Players who have to play turn
	 * @param d the Dice
	 */
	public void playTurn(Players ps, Dice d) {
		Player p = ps.current();
		
		if ((consecutiveTurns == TURNS_TO_PRISON) && d.same()) {
			notice(new PlayerToPrison(p));
			moveToPrison(p);
			consecutiveTurns = 0;
			ps.next();
		} else {
			p.move(d.result());
			action(ps, d.result());

			if (p.broke()) {
				notice(new PlayerBroke(p));
				ps.removeCurrent();
			} else {
				if (!d.same()) {	
					ps.next();
					consecutiveTurns = 0;
					turnsPlayed++;
				} else consecutiveTurns++;
			}
			
		}
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
	
	/**
	 * 
	 * @return the number of the turns played
	 */
	public int getTurnsPlayed() {
		return turnsPlayed;
	}
	
	/**
	 *
	 * @param o the observer to add
	 */
	public void addObserver(Observer o) {
		super.addObserver(o);
		for (Slot s:slots) {
			s.addObserver(o);
		}
	}
	
	/**
	 * 
	 * @param index the index of the property
	 * @return the property at the passed index
	 */
	public Property getProperty(int index) {
		assert index > 0 : "index can't be negative" + index;
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
