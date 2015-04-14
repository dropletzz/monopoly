package monopoly;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class Capital {
	private double value;
	/**
	 * default currency
	 */
	public static String symbol = "euro";
	/**
	 * default currency coefficient
	 */
	public static double coefficient = 1;
	
	/**
	 * Constructor of Capital class
	 * @param value initial capital
	 */
	public Capital(double value) {
		if (value < 0) value = 0;
		this.value = value;
		assert value >= 0 : "value must be greater zero" + value;
	}
	
	/**
	 * 
	 * @return capital formatted string 
	 */
	public String getFormattedValue() {
		return String.format("%.2f %s", value * coefficient, symbol);
	}
	
	/**
	 * 
	 * @return current capital
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * 
	 * @param c capital to be added to current capital
	 */
	public void add(Capital c) {
		this.value += c.value;
	}
	
	/**
	 * 
	 * @param x capital to be added to current capital
	 */
	public void add(double x) {
		this.value += x;
	}
	
	/**
	 * 
	 * @param c capital to take off to current capital
	 */
	public void sub(Capital c) {
		this.value -= c.value;
		if (value < 0) value = 0;
		assert value >= 0 : "value must be greater zero" + value;
	}
	
	/**
	 * 
	 * @param x capital to take off to current capital
	 */
	public void sub(double x) {
		this.value -= x;
		if (value < 0) value = 0;
		assert value >= 0 : "value must be greater zero" + value;
	}
	
	/**
	 * 
	 * @return true if there isn't any capital
	 */
	public boolean finished() {
		return value == 0;
	}
}
