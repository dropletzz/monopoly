package monopoly;

import java.util.Vector;

import monopoly.cards.DecksConstructor;
import monopoly.events.PlayerBroke;
import monopoly.events.PlayerToPrison;
import monopoly.slots.Accident;
import monopoly.slots.Chance;

/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public class GameLogic extends GameEventGenerator {
	
	private static final int MAX_TURNS = 20;
	private static final int TURNS_TO_PRISON = 2;
	private static final double PRISON_TAX = 50;
	
	private Players players;
	final private Board board;
	private byte consecutiveTurns;
	private int turnsPlayed;
	
	/**
	 * Constructor of GameLogic class
	 * @param game
	 */
	public GameLogic(Game game) {
		board = BoardConstructor.createBoard();
		board.setGame(game);
		setGame(game);
		
		consecutiveTurns = 0;
		turnsPlayed = 0;
		
		Chance.setDeck(DecksConstructor.chancesDeck(board.getPrisonPosition()));
		Accident.setDeck(DecksConstructor.accidentsDeck(board.getPrisonPosition()));
	}

	
	/**
	 * play the turn and make the action
	 * @param d the dice
	 */
	public void playTurn(Dice d) {
		prisonCheck(players.current());
		
		if (! noAction(d)) {
			players.current().move(d.result());
			board.action(players, d.result());
		}
	}
	
	/**
	 * check what the player done
	 * @param d the dice 
	 */
	public void endTurn(Dice d) {
		if (players.current().broke()) {
			players.removeCurrent();
			getGame().handleEvent(new PlayerBroke(players.current()));
			playerTurnEnd();
		}
		else
			decideNextPlayer(d);
	}
	
	/**
	 * check if the player can exit to prison
	 * @param p the player to check
	 */
	private void prisonCheck(Player p) {
		if (p.imprisoned()) {
			p.withdrawMoney(PRISON_TAX);
			p.free();
		}
	}
	
	private void playerTurnEnd() {
		turnsPlayed++;
		consecutiveTurns = 0;
	}
	
	private boolean noAction(Dice d) {
		return players.current().broke() || (d.same() && consecutiveTurns == TURNS_TO_PRISON);
	}
	
	private void decideNextPlayer(Dice d) {
		if (d.same()) {
			if (consecutiveTurns == TURNS_TO_PRISON) {
				players.current().imprison();
				getGame().handleEvent(new PlayerToPrison());
				players.next();
				playerTurnEnd();
			}
			else
				consecutiveTurns++;
		}
		else {
			players.next();
			playerTurnEnd();
		}
		
	}
	
	/**
	 * 
	 * @return true if the game is over
	 */
	public boolean gameOver() {
		return (turnsPlayed > MAX_TURNS) || players.single();
	}
	
	/**
	 * 
	 * @return the vector of winners
	 */
	public Vector<Player> getWinners() {
		double maxCapital = 0;
		Vector<Player> winners = new Vector<Player>();
		
		for (Player p:players.toQueue())
			if (p.getCapital().getValue() == maxCapital)
				winners.add(p);
			else if (p.getCapital().getValue() > maxCapital) {
				winners.clear();
				winners.add(p);
				maxCapital = p.getCapital().getValue();
			}
		
		return winners;
	}	
	
	/**
	 * 
	 * @return the current player
	 */
	public Player currentPlayer() {
		return players.current();
	}
	
	/**
	 * 
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}
	
	/**
	 * set the players 
	 * @param ps the players
	 */
	public void setPlayers(Players ps) {
		players = ps;
	}
}
