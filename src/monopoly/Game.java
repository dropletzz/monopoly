package monopoly;
import monopoly.gui.TextGUI;
/**
 * 
 * @author Donatello Rovizzi & Giovanni Caniato
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
		board = BoardConstructor.createBoard(this);
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
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
