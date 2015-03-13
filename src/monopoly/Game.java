package monopoly;
import monopoly.event_handlers.Event;
import monopoly.event_handlers.Observer;
import monopoly.gui.TextGUI;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public final class Game implements Observer {
	private static final int MAX_TURNS = 20;
	
	private Players players;
	final private Board board;
	
	/**
	 * Constructor of Game class
	 */
	public Game() {
		board = BoardConstructor.createBoard();
		board.addObserver(this);
	}
	
	/**
	 * start game
	 */
	public void start() {
		Player current;
		players = TextGUI.getPlayers().shuffle();
		
		while (board.getTurnsPlayed() < MAX_TURNS && !players.single()) {
			current = players.current();
			TextGUI.turnStartMessage(current);
			
			board.playTurn(players, TextGUI.getDice());
			
			if (!current.broke())
				TextGUI.printPropertiesPlayer(current);
			TextGUI.separator();
		}
		
		if (players.single())
			TextGUI.printWinner(players.current());
		else
			TextGUI.printWinners(players);
	}

	/**
	 * respond to a generic event by printing the event's message
	 * @param message 
	 */
	@Override
	public void handleEvent(Event e) {
		TextGUI.alert(e.getMessage());
	}
}
