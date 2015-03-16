package monopoly.events;

import monopoly.Player;
import monopoly.event_handlers.Event;

public class OutOfPrison implements Event {
	
	private Player player;
	private double tax;
	
	public OutOfPrison(Player player, double tax) {
		this.player = player;
		this.tax = tax;
	}

	@Override
	public String getMessage() {
		return String.format("%s paga %.2f per uscire di prigione", player.getName(), tax);
	}

}
