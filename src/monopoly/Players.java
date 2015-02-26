package monopoly;

import java.util.Collections;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;

public final class Players {
	public final static int MIN_PLAYERS = 2;
	public final static int MAX_PLAYERS = 6;

	private ArrayBlockingQueue<Player> players;
	
	public Players(int n) {
		players = new ArrayBlockingQueue<Player>(n);
	}
	
	public Player current() {
		return players.peek();
	}
	
	public Player [] others() {
		Player tmpPlayers [] = new Player [players.size() - 1];
		int i = 0;
		for (Player p:players) {
			if (i != 0)
				tmpPlayers[i-1] = p;
			i++;
		}
		return tmpPlayers;
	}
	
	public Player next() {
		players.add(players.poll());
		return players.peek();
	}
	
	public boolean contains(Player p) {
		return players.contains(p);
	}
	
	public void add(Player p) {
		players.add(p);
	}
	
	public void removeCurrent() {
		players.poll();
	}
	
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
}
