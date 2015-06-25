package monopoly;

import java.util.Collections;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import monopoly.slots.Property;

/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public final class Players {
	/**
	 * the least number of players
	 */
	public final static int MIN_PLAYERS = 2;
	/**
	 * the biggest number of players
	 */
	public final static int MAX_PLAYERS = 6;

	private ArrayBlockingQueue<Player> players;
	
	/**
	 * Constructor of Players class
	 * @param n number of players
	 */
	public Players(int n) {
		assert n > MIN_PLAYERS : n + " players aren't allowed";
		assert n < MAX_PLAYERS : n + " players aren't allowed";
		players = new ArrayBlockingQueue<Player>(n);
	}
	
	/**
	 * 
	 * @return the first player in the queue
	 */
	public Player current() {
		assert players.peek() != null : "the queue is empty";
		return players.peek();
	}
	
	/**
	 * 
	 * @return the array of the players queue unless the first
	 */
	public Player [] others() {
		assert players.size() > 1 : "there aren't players";
		Player tmpPlayers [] = new Player [players.size() - 1];
		int i = 0;
		for (Player p:players) {
			if (i != 0)
				tmpPlayers[i-1] = p;
			i++;
		}
		
		return tmpPlayers;
	}
	
	/**
	 * 
	 * @return the next player who has to play
	 */
	public Player next() {
		players.add(players.poll());
		return players.peek();
	}
	
	/**
	 * 
	 * @param player player to be checked
	 * @return true if the queue contains that player
	 */
	public boolean contains(Player player) {
		return players.contains(player);
	}
	
	/**
	 * 
	 * @param player add p at the queue
	 */
	public void add(Player player) {
		players.add(player);
	}
	
	/**
	 * remove first player in the queue
	 */
	public void removeCurrent() {
		players.poll();
		assert players.size() > 0 : "there aren't players";
	}
	
	/**
	 * 
	 * @return the queue shuffled
	 */
	public Players shuffle() {
		Vector<Player> tmpPlayers = new Vector<Player>();
		for (Player p:players)
			tmpPlayers.add(p);
		Collections.shuffle(tmpPlayers);
		
		Players newPlayers = new Players(players.size());
		for (Player p:tmpPlayers)
			newPlayers.add(p);
		return newPlayers;
	}
	
	/**
	 * 
	 * @return true if the queue is empty
	 */
	public boolean empty() {
		return players.isEmpty();
	}
	
	/**
	 * 
	 * @return true if there is one player in the queue
	 */
	public boolean single() {
		return players.size() == 1;
	}
	
	/**
	 * 
	 * @return the queue of players
	 */
	public Queue<Player> toQueue() {
		return players;
	}
	
	/**
	 * 
	 * @param prop the property
	 * @return the owner player of the property if he exist
	 */
	public Player ownerOf(Property prop) {
		for (Player p:players)
			if (p.owns(prop)) return p;
		return null;
	}
	
	/**
	 * 
	 * @return the number of players
	 */
	public int size() {
		return players.size();
	}
}
