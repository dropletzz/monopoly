package monopoly.events;

import monopoly.Player;
import monopoly.event_handlers.Event;

public class PrintPlayerStatus implements Event {

	private Player player;
	
	public PrintPlayerStatus(Player p) {
		player = p;
	}
	
	@Override
	public String getMessage() {
		return "";
	}
	
	public Player getPlayer() {
		return player;
	}
}
