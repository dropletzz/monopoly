package monopoly;

public final class Board extends MessageSender {
	
	private static final int TURNS_TO_PRISON = 2;
	public static final String POSITION_MESSAGE = "Sei sulla casella %d";

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
		
		if ((consecutiveTurns == TURNS_TO_PRISON) && d.same()) {
			notice(String.format("%s va in prigione!!", p.getName()));
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
