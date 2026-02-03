package at.technikum.state;

import at.technikum.Flipper;

public class PlayingState extends State {
	
	public PlayingState(Flipper flipper) {
		super(flipper);
	}
	
	@Override
	public void pressStart() {System.out.println("Author: Christian Pfneisl");}
	
	@Override
	public void flipLeft() {
		System.out.println("Left Flipper!");
		// TODO: Hier später mit Command Pattern Elemente treffen
		loseBall();
		
	}
	
	@Override
	public void flipRight() {
		System.out.println("Right Flipper!");
		// TODO: Hier später mit Command Pattern Elemente treffen
		
	}
	
	private void loseBall() {
		flipper.decrementRemainingBalls();
		System.out.println("Kugel verloren! Noch " + flipper.getRemainingBalls() + " Kugeln im Spiel.");
		
		if (flipper.getRemainingBalls() == 0) {
			flipper.transitionToEndState();
		}
	}
}
