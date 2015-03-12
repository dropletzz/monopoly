package monopoly;

import monopoly.events.Event;

public class PlayerBroke extends Event {
	
	public Player player;
	
	public PlayerBroke(Player player) {
		this.player = player;
	}
	
	public String getMessage() {
		return String.format("%s ESCE DALLA PARTITA!", player.getName());
	}
}
