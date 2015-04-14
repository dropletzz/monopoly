package monopoly;
/**
 * 
 * @author Donatello Rovizzi & Giovanni Caniato
 *
 */
public final class BoardConstructor {
	
	private final static int DIMENSION = 40;
	private final static int PRISON_POSITION = 10;
	private final static double START_BONUS = 500;
	
	/**
	 *
	 * @param o the observer of the Board
	 * @return the object Board
	 */
	public static Board createBoard(Observer o) {
		Board b = new Board(DIMENSION, PRISON_POSITION, START_BONUS);

		b.addSlot(new EmptySlot("VIA"), 0);
		for (int i=1; i<DIMENSION; i++) {
			if (i%2 == 0)
				b.addSlot(new Tax("Hai comprato un bene di gomma", 1200), i);
			else
				b.addSlot(new ToPrison(PRISON_POSITION, o), i);
		}
		
		return b;
	}
}