package monopoly;

import monopoly.gui.TextGUI;

public final class Game {
	private static final int MAX_TURNS = 3;
	private static final int TURNS_TO_PRISON = 2;
	
	private Players players;
	private Dice dice;
	private int turnsPlayed;
	private byte consecutiveTurns;
	
	public Game() {
		turnsPlayed = 0;
		consecutiveTurns = 0;
	}
	
	public void start() {
		// players = TextGUI.getPlayers();
		players = new Players(4);
		players.add(new Player("giancallo"));
		players.add(new Player("yolanda"));
		players.add(new Player("anguilla"));
		players.add(new Player("frenk"));
		
		while (turnsPlayed < MAX_TURNS) {
			playTurn(players.current());
			
			if ((consecutiveTurns == TURNS_TO_PRISON) && dice.same()) {
				TextGUI.prisonMessage();
				// TODO codice che lo manda in prigione
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
	
	public void playTurn(Player player) {
		TextGUI.turnStartMessage(player);
		dice = TextGUI.getDice();

		// TODO il giocatore si sposta
	}
}
