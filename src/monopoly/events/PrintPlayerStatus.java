package monopoly.events;

import monopoly.Player;

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