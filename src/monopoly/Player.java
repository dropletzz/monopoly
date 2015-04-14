package monopoly;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public final class Player {
	public static final int DEFAULT_POSITION = 0;
	
	private String name;
	private int position;
	
	/**
	 * Constructor of Player class
	 * @param name the name of the player
	 */
	public Player(String name) {
		this.name = name;
		this.position = DEFAULT_POSITION;
	}
	
	/**
	 * 
	 * @return the position of the player in the Board
	 */
	public int getPosition() {
		return position;
	}
	
	/**
	 * 
	 * @param p set player in the position p in the Board
	 */
	public void setPosition(int p) {
		position = p;
	}
	
	/**
	 * 
	 * @return the name of the player
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param o player to be checked
	 * @return true if the name of o is equal of the name of the player
	 */
	public boolean equals(Object o) {
		if (o instanceof Player)
			return ((Player) o).name.equals(this.name);
		else
			return false;
					
	}
}
