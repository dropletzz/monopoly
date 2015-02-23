package monopoly;

public final class BoardConstructor {
	
	private final static int DIMENSION = 40;
	private final static int PRISON_POSITION = 10;
	
	public static Board createBoard() {
		Board b = new Board(DIMENSION, PRISON_POSITION-1);
		
		return b;
	}

}
