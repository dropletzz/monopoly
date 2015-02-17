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
					System.out.println("Nome gi?? esistente! Reinseriscilo");
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
	
	public static void prisonMessage() {
		System.out.println("IN PRIGIONE!");
	}
	
	public static void turnStartMessage(Player p) {
		System.out.println(p.getName() + " tocca a te!");
	}
}
