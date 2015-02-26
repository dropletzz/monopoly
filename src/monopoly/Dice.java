package monopoly;
/**
 * 
 * 
 * @author Donatello Rovizzi & Giovanni Caniato
 *
 */
public final class Dice {
	/**
	 * The least value of dice's face
	 */
	public static final int MIN_RESULT = 1;
	/**
	 * The biggest value of dice's face
	 */
	public static final int MAX_RESULT = 6;
	
	private int a;
	private int b;
	
	/**
	 * Constructor of Dice class
	 * @param a first result of roll
	 * @param b second result of roll
	 */
	public Dice(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	/**
	 * 
	 * @return sum of two rolls
	 */
	public int result() {
		return a+b;
	}
	
	/**
	 * 
	 * @return true if the dice rolls are the same
	 */
	public boolean same() {
		return a == b;
	}
}
