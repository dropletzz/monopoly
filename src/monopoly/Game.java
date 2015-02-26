package monopoly;

import monopoly.gui.TextGUI;

public final class Game implements Observer {
	private static final int MAX_TURNS = 20;
	
	private Players players;
	private Dice dice;
	final private Board board;
	
	public Game() {
		board = BoardConstructor.createBoard();
	}
	
	public void start() {
		board.addObserver(this);
		players = TextGUI.getPlayers().shuffle();
		
		while (board.getTurnsPlayed() < MAX_TURNS) {
			TextGUI.turnStartMessage(players.current());
			
			dice = TextGUI.getDice();
			board.playTurn(players, dice);
			TextGUI.separator();
		}
	}

	@Override
	public void update(String message) {
		TextGUI.alert(message);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
