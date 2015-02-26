package monopoly;

import monopoly.gui.TextGUI;

public final class Game {
	private static final int MAX_TURNS = 20;
	
	private Players players;
	private Dice dice;
	final private Board board;
	
	public Game() {
		board = BoardConstructor.createBoard();
	}
	
	public void start() {
		players = TextGUI.getPlayers().shuffle();
		
		while (board.getTurnsPlayed() < MAX_TURNS) {
			TextGUI.turnStartMessage(players.current());
			TextGUI.printPosition(players.current());
			
			dice = TextGUI.getDice();
			board.playTurn(players, dice);
			TextGUI.separator();
		}
	}
}
