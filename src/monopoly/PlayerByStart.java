package monopoly;

import monopoly.events.Event;

public class PlayerByStart extends Event {
	
	public Player player;
	
	public PlayerByStart(Player player) {
		this.player = player;
	}
	
	public String getMessage() {
		return String.format("%s e' passato dalla casella START: riceve 500.00 euro!", player.getName());
	}
}