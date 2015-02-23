package monopoly;

public final class Player {
	public static final int DEFAULT_POSITION = 0;
	
	private String name;
	private int position;
	
	public Player(String name) {
		this.name = name;
		this.position = DEFAULT_POSITION;
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
}
