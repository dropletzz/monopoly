package monopoly;

import java.util.Vector;

import monopoly.cards.DecksConstructor;
import monopoly.events.PlayerBroke;
import monopoly.events.PlayerToPrison;
import monopoly.slots.Accident;
import monopoly.slots.Chance;

public class GameLogic extends GameEventGenerator {
	
	private static final int MAX_TURNS = 20;
	private static final int TURNS_TO_PRISON = 2;
	private static final double PRISON_TAX = 50;
	
	private Players players;
	final private Board board;
	private byte consecutiveTurns;
	private int turnsPlayed;
	
	public GameLogic(Game game) {
		board = BoardConstructor.createBoard();
		board.setGame(game);
		setGame(game);
		
		consecutiveTurns = 0;
		turnsPlayed = 0;
		
		Chance.setDeck(DecksConstructor.chancesDeck(board.getPrisonPosition()));
		Accident.setDeck(DecksConstructor.accidentsDeck(board.getPrisonPosition()));
	}

	
	
	public void playTurn(Dice d) {
		prisonCheck(players.current());
		
		if (! noAction(d)) {
			players.current().move(d.result());
			board.action(players, d.result());
		}
	}
	
	public void endTurn(Dice d) {
		if (players.current().broke()) {
			players.removeCurrent();
			getGame().handleEvent(new PlayerBroke(players.current()));
			playerTurnEnd();
		}
		else
			decideNextPlayer(d);
	}
	
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
	
	public boolean gameOver() {
		return (turnsPlayed > MAX_TURNS) || players.single();
	}
	
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
	
	public Player currentPlayer() {
		return players.current();
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void setPlayers(Players ps) {
		players = ps;
	}
}
