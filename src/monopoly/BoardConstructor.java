package monopoly;


public final class BoardConstructor {
	
	private final static int DIMENSION = 40;
	private final static int PRISON_POSITION = 10;
	private final static double START_BONUS = 500;
	
	public static Board createBoard() {
		Board b = new Board(DIMENSION, PRISON_POSITION, START_BONUS);
		for (int i=0; i<DIMENSION; i++) {
			b.addSlot(new Tax("Hai comprato un pene di gomma", 1200), i);
		}
		return b;
	}
}