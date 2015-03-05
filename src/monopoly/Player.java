package monopoly;

import java.util.Vector;

import monopoly.slots.Group;
import monopoly.slots.Property;
import monopoly.slots.Terrain;

/**
 * 
 * @author Donatello Rovizzi & Giovanni Caniato
 *
 */
public final class Player {
	/**
	 * default position of the players
	 */
	public static final int DEFAULT_POSITION = 0;
	/**
	 * initial capital of the players
	 */
	public static final double STARTING_CAPITAL = 5000;
	
	
	private String name;
	private int position;
	private Capital capital;
	private Vector<Property> properties;
	
	/**
	 * Constructor of Player class
	 * @param name the name of the player
	 */
	public Player(String name) {
		this.name = name;
		this.position = DEFAULT_POSITION;
		this.capital = new Capital(STARTING_CAPITAL);
		this.properties = new Vector<Property>();
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
	
	/**
	 * 
	 * @return the capital of the player
	 */
	public Capital getCapital() {
		return capital;
	}
	
	/**
	 * 
	 * @param amount amount of money to be added
	 */
	public void addMoney(double amount) {
		capital.add(amount);
	}
	
	/**
	 * 
	 * @param amount amount of money to be remove
	 */
	public void withdrawMoney(double amount) {
		capital.sub(amount);
	}
	
	/**
	 * 
	 * @param c amount of money to be added
	 */
	public void addMoney(Capital c) {
		capital.add(c);
	}
	
	/**
	 * 
	 * @param c amount of money to be remove
	 */
	public void withdrawMoney(Capital c) {
		capital.sub(c);
	}
	
	/**
	 * 
	 * @return true if the player has broked
	 */
	public boolean broke() {
		return capital.finished();
	}
	
	/**
	 * 
	 * @return the formatting of the player's capital
	 */
	public String getValue() {
		return capital.getFormattedValue();
	}
	
	public void addProperty(Property p) {
		properties.add(p);
	}
	
	public boolean owns(Property p) {
		return properties.contains(p);
	}
	
	public boolean owns(Group g) {
		for (Property p:g.getProperties())
			if (!this.owns(p)) return false;
		return true;
	}
}
