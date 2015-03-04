package monopoly;

import monopoly.slots.Slot;


/**
 * 
 * 
 * @author Donatello Rovizzi & Giovanni Caniato
 *
 */
public final class Board extends MessageSender {
	
	private static final int TURNS_TO_PRISON = 2;
	public static final String POSITION_MESSAGE = "Sei sulla casella %d";

	final private Slot slots [];
	final private int dimension;
	final private int prison;
	final private double startBonus;
	private byte consecutiveTurns;
	private int turnsPlayed;
	
	/**
	 * Constructor of Game class
	 * @param dimension of the board
	 * @param prison the slot of the prison
	 * @param startBonus bonus if start slot is active 
	 */
	public Board(int dimension, int prison, double startBonus) {
		this.dimension = dimension;
		this.slots = new Slot [dimension];
		this.prison = prison;
		this.startBonus = startBonus;
		this.consecutiveTurns = 0;
		this.turnsPlayed = 0;
	}
	
	/**
	 * 
	 * @param index the index of the slot 
	 * @return the slot at the position of the index
	 */
	public Slot getSlot (int index) {
		return slots[index];
	}
	
	/**
	 * 
	 * @param s the slot to add
	 * @param position the position of the slot
	 */
	public void addSlot(Slot s, int position) {
		slots[position] = s;
	}
	
	/**
	 * 
	 * @param p Players involved in the action
	 */
	private void action(Players p, Dice d) {
		slots[p.current().getPosition()].action(p, d);
	}

	/**
	 * 
	 * @param ps Players who have to play turn
	 * @param d the Dice
	 */
	public void playTurn(Players ps, Dice d) {
		Player p = ps.current();
		
		if ((consecutiveTurns == TURNS_TO_PRISON) && d.same()) {
			notice(String.format("%s va in prigione!! [Casella %d]", p.getName(), prison));
			moveToPrison(p);
			consecutiveTurns = 0;
			ps.next();
		}
		else {
			p.setPosition((p.getPosition() + d.result()) % dimension);
			
			if (passedStart(p, d.result())) {
				p.addMoney(startBonus);
				notice(String.format("%s e' passato dalla casella START: riceve 500.00 euro!", p.getName()));
			}
			
			action(ps, d);
			
			if (p.broke()) {
				notice(String.format("%s ESCE DALLA PARTITA!", p.getName()));
				ps.removeCurrent();
			}
			else {
				notice(String.format(POSITION_MESSAGE, p.getPosition()));
				if (!d.same()) {	
					ps.next();
					consecutiveTurns = 0;
					turnsPlayed++;
				}
				else consecutiveTurns++;
			}
		}
	}
	
	/**
	 * 
	 * @param p the player who has moved
	 * @param result the result of the roll dices
	 * @return true the player is passed by Start
	 */
	private boolean passedStart(Player p, int result) {
		return (p.getPosition() + result) >= dimension;
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
}
