package at.technikum.state;

import at.technikum.Flipper;

public class NoCreditState extends State {
	
	public NoCreditState(Flipper flipper) {
		super(flipper);
	}
	
	@Override
	public void pressStart() {
		System.out.println("Kein Kredit vorhanden!");
		System.out.println("Bitte Münze einwerfen.");
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
