package monopoly;

public final class Board {
	
	final private Slot slots [];
	final private int dimension;
	final private int prison;
	
	public Board(int dimension, int prison) {
		this.dimension = dimension;
		this.slots = new Slot [dimension];
		this.prison = prison;
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

	public void move(Player p, int result) {
		p.setPosition((p.getPosition() + result) % dimension);
	}
        
        public void moveToPrison(Player p) {
		p.setPosition(prison);
	}

	public int getPrisonPosition() {
		return prison;
	}
}