package monopoly.gui;

import java.util.Vector;

import monopoly.Board;
import monopoly.Dice;
import monopoly.Player;
import monopoly.Players;
import utils.InputDati;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public final class TextGUI {

	/**
	 * 
	 * @param b the board
	 * @return the Players just created
	 */
	public static Players getPlayers(Board b) {
		int num = InputDati.readInteger("Quanti giocatori? ", Players.MIN_PLAYERS, Players.MAX_PLAYERS);
		Players players = new Players(num);
		for (int i = 0; i < num; i++) {
			Player p;
			do {
				p = getPlayer(i+1, b);
				if (players.contains(p)) {
					System.out.println("Nome gia' esistente! Reinseriscilo");
				}
			} while (players.contains(p));
			players.add(p);
		}
		
		return players;
	}
	
	/**
	 * 
	 * @param n the number of the player
	 * @param board the board
	 * @return the player n
	 */
	public static Player getPlayer(int n, Board board) {
		String name = InputDati.readStringNoEmpty(String.format("Inserisci il nome del giocatore %d: ", n));
		return new Player(name, board);
	}
	
	/**
	 * 
	 * @return the dice just created
	 */
	public static Dice getDice() {
		int a = InputDati.readInteger("Risultato primo lancio: ", Dice.MIN_RESULT, Dice.MAX_RESULT);
		int b = InputDati.readInteger("Risultato secondo lancio: ", Dice.MIN_RESULT, Dice.MAX_RESULT);
		
		return new Dice(a,b);
	}
	
	/**
	 * 
	 * @param player print that the player goes to the prison
	 */
	public static void prisonMessage(Player player) {
		System.out.println(String.format("%s va in prigione!", player.getName()));
	}
	
	/**
	 * 
	 * @param player print that is turn of player p
	 */
	public static void turnStartMessage(Player player) {
		System.out.println(String.format("%s tocca a te! [Casella %d]\nCapitale: %s",
				player.getName(), player.getPosition(), player.getValue()));
	}
	
	/**
	 * 
	 * @param player print the position of player p
	 */
	public static void printPosition(Player player) {
		System.out.println(String.format("Sei sulla casella %d", player.getPosition()));
	}
	
	/**
	 * 
	 * print the separator each turn
	 */
	public static void separator() {
		System.out.println("$-------------------------------------------$");
	}
	
	/**
	 * 
	 * @param player print the player p is broked
	 */
	public static void playerBroke(Player player) {
		System.out.println(String.format("%s e' fallito!", player.getName()));
	}
	
	/**
	 * 
	 * @param s print the string s
	 */
	public static void alert(String s) {
		System.out.println(s);
	}
	
	/**
	 * 
	 * @param player print that player p wins the game
	 */
	public static void printWinner(Player player) {
		System.out.println(String.format("HA VINTO %s", player.getName()));
	}
	
	/**
	 * 
	 * @param players print that players ps win the game
	 */
	public static void printWinners(Vector<Player> players) {
		for (Player p:players)
			printWinner(p);
	}
	
	/**
	 * 
	 * @param player print the list of properties of player p
	 */
	public static void printPropertiesPlayer(Player player) {
		System.out.println(String.format("\nVa sulla casella %d\nCapitale: %s", player.getPosition(), player.getValue()));
		if(player.getProperties() == null)
			System.out.println(String.format("%s non e' in possesso di nessuna proprieta'", player.getName()));
		else {
			System.out.println(String.format("%s e' in possesso di:", player.getName()));
			for (int i = 0; i < player.getProperties().size(); i++)
				System.out.println(String.format("\t-%s", player.getProperties().get(i).getName()));
		}
	}
}
