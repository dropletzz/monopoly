package monopoly.cards;

public class DecksConstructor {
	// TODO sostituire tutti i prezzi con Capital.format(...)
	
	public static Deck chancesDeck(int prisonPosition) {
		Deck d = new Deck();
		d.addCard(new GoToNoStartBonus(1, "Ritornate al Vicolo Corto"));
		d.addCard(new AddMoney(60, "E' maturata la cedola delle vostre azioni: ritirate euro 60 dalla banca"));
		d.addCard(new WithdrawMoney(125, "Scade il vostro premio di assicurazione: pagate euro 125 in banca"));
		d.addCard(new GoTo(0, "Andate avanti sino al “VIA!” e ritirate euro 500 dalla banca"));
		d.addCard(new AddMoney(500, "Siete creditori verso la banca di euro 500: ritirateli"));
		d.addCard(new WithdrawMoney(250, "Avete perso una causa: pagate euro 250 in banca"));
		d.addCard(new GoToPrison(prisonPosition, "Andate in prigione direttamente, senza passare dal “VIA!”"));
		d.addCard(new Birthday(25, "E' il vostro compleanno: ogni giocatore vi regala euro 25"));
		
		d.shuffle();
		return d;
	}
	
	public static Deck accidentsDeck(int prisonPosition) {
		Deck d = new Deck();
		d.addCard(new GoTo(24, "Andate sino a Largo Colombo: se passate dal “VIA!”, ritirate euro 500 dalla banca"));
		d.addCard(new GoToPrison(prisonPosition, "Andate in prigione direttamente, senza passare dal “VIA!”"));
		d.addCard(new Move(-3, "Fate tre passi indietro"));
		d.addCard(new GoTo(11, "Andate sino a Via Accademia: se passate dal “VIA!”, ritirate euro 500 dalla banca"));
		d.addCard(new WithdrawMoney(50, "Versate in banca euro 50 per beneficienza"));
		d.addCard(new AddMoney(375, "Maturano le cedole delle vostre cartelle di rendita: ritirate euro 375 dalla banca"));
		d.addCard(new AddMoney(125, "La banca vi paga gli interessi del vostro conto corrente: ritirate euro 125"));
		d.addCard(new GoTo(0, "Andate avanti sino al “VIA!” e ritirate euro 500 dalla banca"));
		
		d.shuffle();
		return d;
	}
}