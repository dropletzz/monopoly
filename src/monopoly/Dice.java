package monopoly;

public final class Dice {
	public static final int MIN_RESULT = 1;
	public static final int MAX_RESULT = 6;
	
	private int a;
	private int b;
	
	public Dice(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int result() {
		return a+b;
	}
	
	public boolean same() {
		return a == b;
	}
}
