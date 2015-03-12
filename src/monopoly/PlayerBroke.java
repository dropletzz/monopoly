package monopoly;

import monopoly.events.Event;

public class PlayerBroke implements Event {
	
	private Player player;
	
	public PlayerBroke(Player player) {
		this.player = player;
	}
	
	public String getMessage() {
		return String.format("%s ESCE DALLA PARTITA!", player.getName());
	}

	public Player getPlayer() {
		return player;
	}
}
