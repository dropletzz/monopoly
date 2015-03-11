package monopoly;

import monopoly.events.Event;

public class PlayerToPrison extends Event {
	
	public Player player;
	
	public PlayerToPrison(Player player) {
		this.player = player;
	}
	
	public String getMessage() {
		return String.format("%s finisce in prigione!", player.getName());
	}
}