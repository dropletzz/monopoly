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
	 * @param b the board
	 * @return the player n
	 */
	public static Player getPlayer(int n, Board b) {
		String name = InputDati.readStringNoEmpty(String.format("Inserisci il nome del giocatore %d: ", n));
		return new Player(name, b);
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
	 * @param p print that is turn of player p
	 */
	public static void turnStartMessage(Player p) {
		System.out.println(String.format("%s tocca a te! [Casella %d]\nCapitale: %s",
				p.getName(), p.getPosition(), p.getValue()));
	}
	
	/**
	 * 
	 * @param p print the position of player p
	 */
	
	public static void printPosition(Player p) {
		System.out.println(String.format("Sei sulla casella %d", p.getPosition()));
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
	 * @param p print the player p is broked
	 */
	public static void playerBroke(Player p) {
		System.out.println(String.format("%s e' fallito!", p.getName()));
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
	 * @param p print that player p wins the game
	 */
	public static void printWinner(Player p) {
		System.out.println(String.format("HA VINTO %s", p.getName()));
	}
	
	/**
	 * 
	 * @param ps print that players ps win the game
	 */
	public static void printWinners(Vector<Player> ps) {
		for (Player p:ps)
			printWinner(p);
	}
	
	/**
	 * 
	 * @param p print the list of properties of player p
	 */
	public static void printPropertiesPlayer(Player p) {
		System.out.println(String.format("\nVa sulla casella %d\nCapitale: %s", p.getPosition(), p.getValue()));
		if(p.getProperties() == null)
			System.out.println(String.format("%s non e' in possesso di nessuna proprieta'", p.getName()));
		else {
			System.out.println(String.format("%s e' in possesso di:", p.getName()));
			for (int i = 0; i < p.getProperties().size(); i++)
				System.out.println(String.format("\t-%s", p.getProperties().get(i).getName()));
		}
	}
}
