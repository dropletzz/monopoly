package monopoly;

public final class Board {
	
	private Slot slots [];
	private int dimension;
	private int prison;
	
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

}
