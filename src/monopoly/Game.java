package monopoly;
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
	private Dice dice;
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
		board.addObserver(this);
		players = TextGUI.getPlayers().shuffle();
		
		while (board.getTurnsPlayed() < MAX_TURNS && !players.single()) {
			TextGUI.turnStartMessage(players.current());
			
			dice = TextGUI.getDice();
			board.playTurn(players, dice);
			//TextGUI.printPropertiesPlayer(players.current());
			TextGUI.separator();
		}
		
		if (players.single())
			TextGUI.printWinner(players.current());
		else
			TextGUI.printWinners(players);
	}

	/**
	 * update the observer
	 * @param message 
	 */
	@Override
	public void update(String message) {
		TextGUI.alert(message);
	}

	/**
	 * update the observer
	 */
	@Override
	public void update() {}
}
