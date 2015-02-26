package monopoly;

public class Capital {
	// invariante di classe -> value deve essere sempre positivo
	private double value;
	public static String symbol = "€";
	public static double coefficient = 1;
	
	public Capital(double value) {
		this.value = value;
		if (value < 0) value = 0;
	}
	
	public String getFormattedValue() {
		return String.format("%.2f %s", value * coefficient, symbol);
	}
	
	public double getValue() {
		return value;
	}
	
	public void add(Capital c) {
		this.value += c.value;
	}
	
	public void add(double x) {
		this.value += x;
	}
	
	public void sub(Capital c) {
		this.value -= c.value;
		if (value < 0) value = 0;
	}
	
	public void sub(double x) {
		this.value -= x;
		if (value < 0) value = 0;
	}
	
	public boolean finished() {
		return value == 0;
	}
}
