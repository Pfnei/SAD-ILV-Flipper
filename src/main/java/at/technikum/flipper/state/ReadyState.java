package at.technikum.flipper.state;

import at.technikum.flipper.Flipper;

public class ReadyState extends State{
	
	public ReadyState(Flipper flipper) {
		super(flipper);
	}
	
	@Override
	public void pressStart() {
		flipper.useOneCredit();
		flipper.showGameStart();
		flipper.transitionToPlaying();
	}
	
	@Override
	public void flipLeft() {
	
	}
	
	@Override
	public void flipRight() {
	
	}
}
