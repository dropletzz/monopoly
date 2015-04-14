package monopoly;

import monopoly.slots.*;
/**
 * 
 * 
 * @author Giovanni Caniato, Donatello Rovizzi, Mattia Pescimoro 
 *
 */
public final class BoardConstructor {
	
	private final static int DIMENSION = 40;
	private final static int PRISON_POSITION = 10;
	private final static double START_BONUS = 500;
	
	/**
	 *
	 * @return the object Board
	 */
	public static Board createBoard() {
		Board b = new Board(DIMENSION, PRISON_POSITION, START_BONUS);

		b.addSlot(new EmptySlot("VIA"), 0);
		b.addSlot(new Terrain("Vicolo Corto", 60), 1);
		b.addSlot(new Chance(), 2);
		b.addSlot(new Terrain("Vicolo Stretto", 60), 3);
		b.addSlot(new Tax("Tassa patrimoniale", 250), 4);
		b.addSlot(new Station("Stazione sud", 20), 5);
		b.addSlot(new Terrain("Bastioni Gran Sasso", 100), 6);
		b.addSlot(new Accident(), 7);
		b.addSlot(new Terrain("Viale Monterosa", 100), 8);
		b.addSlot(new Terrain("Viale Vesuvio", 120), 9);
		b.addSlot(new Prison("Prigione/Transito"), 10);
		
		b.addSlot(new Terrain("Via Accademia", 140), 11);
		b.addSlot(new Society("Societa' elettrica", 150), 12);
		b.addSlot(new Terrain("Corso Ateneo", 140), 13);
		b.addSlot(new Terrain("Piazza Universita'", 160), 14);
		b.addSlot(new Station("Stazione ovest", 20), 15);
		b.addSlot(new Terrain("Via Verdi", 180), 16);
		b.addSlot(new Chance(), 17);
		b.addSlot(new Terrain("Corso Raffaello", 180), 18);
		b.addSlot(new Terrain("Piazza Dante'", 200), 19);
		b.addSlot(new EmptySlot("Posteggio gratuito'"), 20);
		
		b.addSlot(new Terrain("Via Marco Polo", 220), 21);
		b.addSlot(new Accident(), 22);
		b.addSlot(new Terrain("Corso Magellano", 220), 23);
		b.addSlot(new Terrain("Largo Colombo", 240), 24);
		b.addSlot(new Station("Stazione nord", 20), 25);
		b.addSlot(new Terrain("Viale Costantino", 280), 26);
		b.addSlot(new Terrain("Viale Traiano", 260), 27);
		b.addSlot(new Society("Acqua potabile", 150), 28);
		b.addSlot(new Terrain("Piazza Giulio Cesare", 280), 29);
		b.addSlot(new ToPrison("IN PRIGIONE!", PRISON_POSITION), 30);
		
		b.addSlot(new Terrain("Via Roma", 300), 31);
		b.addSlot(new Terrain("Corso Impero", 300), 32);
		b.addSlot(new Chance(), 33);
		b.addSlot(new Terrain("Largo Augusto", 320), 34);
		b.addSlot(new Station("Stazione est", 20), 35);
		b.addSlot(new Accident(), 36);
		b.addSlot(new Terrain("Viale dei Giardini", 350), 37);
		b.addSlot(new Tax("Tassa di lusso", 10), 38);
		b.addSlot(new Terrain("Parco della Vittoria", 400), 39);
		
		new Group(b.getProperty(1), b.getProperty(3));
		new Group(b.getProperty(6), b.getProperty(8), b.getProperty(9));
		new Group(b.getProperty(11), b.getProperty(13), b.getProperty(14));
		new Group(b.getProperty(16), b.getProperty(18), b.getProperty(19));
		new Group(b.getProperty(21), b.getProperty(23), b.getProperty(24));
		new Group(b.getProperty(26), b.getProperty(27), b.getProperty(29));
		new Group(b.getProperty(31), b.getProperty(32), b.getProperty(34));
		new Group(b.getProperty(37), b.getProperty(39));
		new Group(b.getProperty(12), b.getProperty(28));
		
		return b;
	}
}