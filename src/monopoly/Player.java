package monopoly;

public final class Player {
	public static final int DEFAULT_POSITION = 0;
	public static final double STARTING_CAPITAL = 5000;
	
	
	private String name;
	private int position;
	private Capital capital;
	
	public Player(String name) {
		this.name = name;
		this.position = DEFAULT_POSITION;
		this.capital = new Capital(STARTING_CAPITAL);
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int p) {
		position = p;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Player)
			return ((Player) o).name.equals(this.name);
		else
			return false;	
	}
	
	public Capital getCapital() {
		return capital;
	}
	
	public void addMoney(double amount) {
		capital.add(amount);
	}
	
	public void withdrawMoney(double amount) {
		capital.sub(amount);
	}
	
	public boolean broke() {
		return capital.finished();
	}
	
	public String getValue() {
		return capital.getFormattedValue();
	}
}
