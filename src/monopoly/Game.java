package monopoly;
import monopoly.cards.DecksConstructor;
import monopoly.events.Event;
import monopoly.events.PrintPlayerStatus;
import monopoly.gui.TextGUI;
import monopoly.slots.Accident;
import monopoly.slots.Chance;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public final class Game {
	private static final int MAX_TURNS = 20;
	
	private Players players;
	final private Board board;
	
	/**
	 * Constructor of Game class
	 */
	public Game() {
		board = BoardConstructor.createBoard();
		board.setGame(this);
		Chance.setDeck(DecksConstructor.chancesDeck(board.getPrisonPosition()));
		Accident.setDeck(DecksConstructor.accidentsDeck(board.getPrisonPosition()));
	}
	
	/**
	 * start game
	 */
	public void play() {
		Player current;
		players = TextGUI.getPlayers(board).shuffle();
		
		while (board.getTurnsPlayed() < MAX_TURNS && !players.single()) {
			current = players.current();
			TextGUI.turnStartMessage(current);
			
			board.playTurn(players, TextGUI.getDice());
			
			TextGUI.separator();
		}
		
		TextGUI.printWinners(board.getWinners(players));
	}

	/**
	 * respond to a generic event by printing the event's message
	 * @param e the event 
	 */
	public void handleEvent(Event e) {
		TextGUI.alert(e.getMessage());
	}
	
	/**
	 * 
	 * @param e event PrintPlayerStatus to be printed
	 */
	public void handleEvent(PrintPlayerStatus e) {
		TextGUI.printPropertiesPlayer(e.getPlayer());
	}
}