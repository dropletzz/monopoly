package monopoly.gui;

import monopoly.*;
import utils.InputDati;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public final class TextGUI {

	public static Players getPlayers() {
		int num = InputDati.readInteger("Quanti giocatori? ", Players.MIN_PLAYERS, Players.MAX_PLAYERS);
		Players players = new Players(num);
		for (int i = 0; i < num; i++) {
			Player p;
			do {
				p = getPlayer(i+1);
				if (players.contains(p)) {
					System.out.println("Nome gia' esistente! Reinseriscilo");
				}
			} while (players.contains(p));
			players.add(p);
		}
		
		return players;
	}
	
	public static Player getPlayer(int n) {
		String name = InputDati.readStringNoEmpty(String.format("Inserisci il nome del giocatore %d: ", n));
		return new Player(name);
	}
	
	public static Dice getDice() {
		int a = InputDati.readInteger("Risultato primo lancio: ", Dice.MIN_RESULT, Dice.MAX_RESULT);
		int b = InputDati.readInteger("Risultato secondo lancio: ", Dice.MIN_RESULT, Dice.MAX_RESULT);
		
		return new Dice(a,b);
	}
	
	public static void prisonMessage(Player player) {
		System.out.println(String.format("%s va in prigione!", player.getName()));
	}
	
	public static void turnStartMessage(Player p) {
		System.out.println(String.format("%s tocca a te! [Casella %d]\nCapitale: %s",
				p.getName(), p.getPosition(), p.getValue()));
	}
	
	public static void printPosition(Player p) {
		System.out.println(String.format("Sei sulla casella %d", p.getPosition()));
	}
	
	public static void separator() {
		System.out.println("$-------------------------------------------$");
	}
	
	public static void playerBroke(Player p) {
		System.out.println(String.format("%s e' fallito!", p.getName()));
	}
	
	public static void alert(String s) {
		System.out.println(s);
	}
	
	public static void printWinner(Player p) {
		System.out.println(String.format("HA VINTO %s", p.getName()));
	}
	
	public static void printWinners(Players ps) {
		for (Player p:ps.toQueue())
			printWinner(p);
	}
	
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
	
	
	/*public static void printBoard(Board board) {
		for (int i = 0; i < board.DIMENSION; i ++) {
			System.out.println(String.format("Slot %d: ", board.getSlot(i)));
		}
	}*/
}
