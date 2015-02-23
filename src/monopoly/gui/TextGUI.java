package monopoly.gui;

import monopoly.*;
import utils.InputDati;

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
		System.out.println(String.format("%s tocca a te!", p.getName()));
	}
	
	public static void printPosition(Player p) {
		System.out.println(String.format("Sei sulla casella %d", p.getPosition()));
	}
	
	public static void separator() {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}
	
	/*public static void printBoard(Board board) {
		for (int i = 0; i < board.DIMENSION; i ++) {
			System.out.println(String.format("Slot %d: ", board.getSlot(i)));
		}
	}*/
}
