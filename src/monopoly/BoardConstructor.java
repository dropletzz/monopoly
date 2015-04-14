package monopoly;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public final class BoardConstructor {
	
	private final static int DIMENSION = 40;
	private final static int PRISON_POSITION = 10;
	
	/**
	 *
	 * @return the object Board
	 */
	public static Board createBoard() {
		Board b = new Board(DIMENSION, PRISON_POSITION);
		for (int i=0; i<DIMENSION; i++) {
			b.addSlot(new Prison(), i);
		}
		return b;
	}
}
