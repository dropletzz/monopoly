package monopoly;

public final class EmptySlot extends Slot {

	public EmptySlot() {
		super("");
	}
	
	public EmptySlot(String name) {
		super(name);
	}
	
	@Override
	public void action(Players p) {}

}
