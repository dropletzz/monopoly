package monopoly;

import monopoly.gui.TextGUI;

public final class Game {
	private static final int MAX_TURNS = 20;
	private static final int TURNS_TO_PRISON = 2;
	
	private Players players;
	private Dice dice;
	private int turnsPlayed;
	private byte consecutiveTurns;
	final private Board board;
	
	public Game() {
		turnsPlayed = 0;
		consecutiveTurns = 0;
		board = BoardConstructor.createBoard();
	}
	
	public void start() {
		players = TextGUI.getPlayers().shuffle();
		
		while (turnsPlayed < MAX_TURNS) {
			playTurn(players.current());
			decideNextPlayer();
			TextGUI.separator();
		}
	}
	
	private void playTurn(Player player) {
		TextGUI.turnStartMessage(player);
		TextGUI.printPosition(player);
		dice = TextGUI.getDice();
		board.move(player, dice.result());
		board.action(players);
		TextGUI.printPosition(player);
	}
	
	private void decideNextPlayer() {
		if ((consecutiveTurns == TURNS_TO_PRISON) && dice.same()) {
			TextGUI.prisonMessage(players.current());
                        board.moveToPrisonPosition(players.current());
                        consecutiveTurns = 0;
		}
		else if (dice.same())
			consecutiveTurns++;
		
		if (!dice.same() || consecutiveTurns == 0) {
			players.next();
			turnsPlayed++;
			consecutiveTurns = 0;
		}
	}
}
