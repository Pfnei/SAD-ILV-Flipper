package at.technikum.flipper.state;

import at.technikum.flipper.Flipper;

import static at.technikum.flipper.util.InputUtil.askForYesNo;

public class NoCreditState extends State {
	
	public NoCreditState(Flipper flipper) {
		super(flipper);
	}
	
	@Override
	public void pressStart() {
		System.out.println("Kein Kredit vorhanden!");
		System.out.println("Bitte Münze einwerfen.");
		var insertCoin = askForYesNo("Willst du eine Münze einwerfen? (Y/N)");
		if (insertCoin) {
			flipper.insertCoin();
			flipper.pressStart();
		}
		else{
			flipper.endGame();
		}
	}
	
	@Override
	public void flipLeft() {
		// ev. Highscore anzeigen
	}
	
	@Override
	public void flipRight() {
		// ev. Highscore anzeigen
	}
}
