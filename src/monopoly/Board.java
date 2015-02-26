package monopoly;

import monopoly.gui.TextGUI;

public final class Board {
	
	private static final int TURNS_TO_PRISON = 2;

	final private Slot slots [];
	final private int dimension;
	final private int prison;
	final private double startBonus;
	private byte consecutiveTurns;
	private int turnsPlayed;
	
	
	public Board(int dimension, int prison, double startBonus) {
		this.dimension = dimension;
		this.slots = new Slot [dimension];
		this.prison = prison;
		this.startBonus = startBonus;
		this.consecutiveTurns = 0;
		this.turnsPlayed = 0;
	}
	
	public Slot getSlot (int index) {
		return slots[index];
	}
	
	public void addSlot(Slot s, int position) {
		slots[position] = s;
	}
	
	public void action(Players p) {
		slots[p.current().getPosition()].action(p);
	}

	public void playTurn(Players ps, Dice d) {
		Player p = ps.current();
		// notify [posizione]
		
		if ((consecutiveTurns == TURNS_TO_PRISON) && d.same()) {
			// notify TextGUI.prisonMessage(p);
			moveToPrison(p);
			consecutiveTurns = 0;
			ps.next();
		}
		else {
			p.setPosition((p.getPosition() + d.result()) % dimension);
			
			if (passedStart(p, d.result())) {
				p.addMoney(startBonus);
				// notify
			}
			
			action(ps);
			
			if (p.broke()) {
				// notify TextGUI.playerBroke(p);
				ps.removeCurrent();
			}
			else {
				if (!d.same()) {
					// notify [posizione]
					ps.next();
					consecutiveTurns = 0;
					turnsPlayed++;
				}
				else consecutiveTurns++;
			}
		}
	}
	
	private boolean passedStart(Player p, int result) {
		return (p.getPosition() + result) >= dimension;
	}
        
    public void moveToPrison(Player p) {
		p.setPosition(prison);
	}

	public int getPrisonPosition() {
		return prison;
	}
	
	public int getTurnsPlayed() {
		return turnsPlayed;
	}
}
