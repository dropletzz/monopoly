package monopoly;

import monopoly.events.Event;

public class PlayerByStart implements Event {
	
	private Player player;
	
	public PlayerByStart(Player player) {
		this.player = player;
	}
	
	public String getMessage() {
		return String.format("%s e' passato dalla casella START: riceve 500.00 euro!", player.getName());
	}

	public Player getPlayer() {
		return player;
	}
}