package at.technikum.flipper.state;

import at.technikum.flipper.Flipper;

import static at.technikum.flipper.util.Util.randomInt;

public class PlayingState extends State {
	
	public PlayingState(Flipper flipper) {
		super(flipper);
	}
	
	@Override
	public void pressStart() {System.out.println("\nAuthor: Christian Pfneisl\n");}
	
	@Override
	public void flipLeft() {
		if ( 1 == randomInt (1,flipper.getFailRateLeft())){
			loseBall();
		}
		else {
			System.out.println("\nKugel getroffen - du räumst weiter ab!\n");
		}
		
	}
	
	@Override
	public void flipRight() {
		if ( 1 == randomInt (1,flipper.getFailRateRight())){
			loseBall();
		}
		else {
			System.out.println("\nKugel getroffen - du räumst weiter ab!\n");
		}
		
	}
	
	private void loseBall() {
		flipper.decrementRemainingBalls();
		System.out.println("\nKugel verloren! Noch " + flipper.getRemainingBalls() + " Kugeln im Spiel.\n");
		
		if (flipper.getRemainingBalls() == 0) {
			flipper.transitionToEndState();
		}
	}
}
