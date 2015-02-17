package monopoly;

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
}
