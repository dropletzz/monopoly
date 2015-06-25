package monopoly;

import java.util.Vector;

import monopoly.slots.Group;
import monopoly.slots.Property;
import monopoly.slots.Slot;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
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
	private Board board;
	private boolean imprisoned;
	
	/**
	 * Constructor of Player class
	 * @param name the name of the player
	 */
	public Player(String name, Board board) {
		this.name = name;
		this.position = DEFAULT_POSITION;
		this.capital = new Capital(STARTING_CAPITAL);
		this.properties = new Vector<Property>();
		this.board = board;
		this.imprisoned = false;
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
	 * player move forward 
	 * @param result the dice roll
	 */
	public void move(int result) {
		assert result > 0 : "result must be positive";
		int sum = position + result;
		if (sum >= board.size()) addMoney(board.getStartBonus());
		position = sum % board.size();
	}
	
	/**
	 * player move back 
	 * @param amount how much player move back
	 */
	public void moveBack(int amount) {
		assert amount > 0 : "amount must be positive";
		position = position - amount;
	}
	
	/**
	 * 
	 * @param dest the destination slot
	 */
	public void moveTo(int dest) {
		if (dest < position) addMoney(board.getStartBonus());
		position = dest;
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
	
	/**
	 * 
	 * @param prop the player add p of his properties 
	 */
	public void addProperty(Property prop) {
		properties.add(prop);
	}
	
	/**
	 * 
	 * @param prop property to be checked
	 * @return true if the player has the property
	 */
	public boolean owns(Property prop) {
		return properties.contains(prop);
	}
	
	/**
	 * 
	 * @param g the group of properties
	 * @return true if the player controls all group
	 */
	public boolean owns(Group g) {
		for (Property p:g.getProperties())
			if (!this.owns(p)) return false;
		return true;
	}
	
	/**
	 * 
	 * @return the vector of all properties of the player
	 */
	public Vector<Property> getProperties() {
		if (properties.size() > 0)
			return properties;
		return null;
	}
	
	/**
	 * 
	 * @param prop the property 
	 * @return true if the player can buy the property
	 */
	public boolean canBuy(Property prop) {
		return prop.getValue() < capital.getValue();
	}
	
	/**
	 * 
	 * @return the slot
	 */
	public Slot getSlot() {
		return board.getSlot(position);
	}
	
	/**
	 * set player imprisoned
	 */
	public void imprison() {
		imprisoned = true;
		position = board.getPrisonPosition();
	}
	
	/**
	 * set player free
	 */
	public void free() {
		imprisoned = false;
	}
	
	/**
	 * 
	 * @return true if player is imprisoned
	 */
	public boolean imprisoned() {
		return imprisoned;
	}
}
