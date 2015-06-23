package monopoly;

import java.util.Vector;
import monopoly.gui.TextGUI;

/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public final class Game {

	private GameLogic gameLogic;
	
	/**
	 * Constructor of Game class
	 */
	public Game() {
		gameLogic = new GameLogic(this);
	}
	
	/**
	 * start game
	 */
	public void play() {
		gameLogic.setPlayers(TextGUI.getPlayers(gameLogic.getBoard()));
		
		while (! gameLogic.gameOver()) {
			TextGUI.turnStartMessage(gameLogic.currentPlayer());
			Dice d = TextGUI.getDice();
			gameLogic.playTurn(d);
			TextGUI.printPropertiesPlayer(gameLogic.currentPlayer());
			gameLogic.endTurn(d);
			TextGUI.separator();
		}
		
		Vector<Player> winners = gameLogic.getWinners();
		if (winners.size() > 1)
			TextGUI.printWinners(winners);
		else
			TextGUI.printWinner(winners.firstElement());
	}

	/**
	 * respond to a generic event by printing the event's message
	 * @param e the event 
	 */
	public void handleEvent(Event e) {
		TextGUI.alert(e.getMessage());
	}
}