package monopoly.cards;

public class DecksConstructor {
	
	public static Deck chancesDeck() {
		Deck d = new Deck();
		d.addCard(new AddMoney(200));
		
		return d;
	}
	
	public static Deck accidentsDeck() {
		Deck d = new Deck();
		d.addCard(new WithdrawMoney(200));
		
		return d;
	}
}