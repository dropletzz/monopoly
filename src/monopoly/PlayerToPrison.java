package monopoly;

import monopoly.events.Event;

public class PlayerToPrison implements Event {
	
	private Player player;
	
	public PlayerToPrison(Player player) {
		this.player = player;
	}
	
	public String getMessage() {
		return String.format("%s finisce in prigione!", player.getName());
	}

	public Player getPlayer() {
		return player;
	}
}