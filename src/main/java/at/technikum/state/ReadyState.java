package at.technikum.state;

import at.technikum.Flipper;

public class ReadyState extends State{
	
	public ReadyState(Flipper flipper) {
		super(flipper);
	}
	
	@Override
	public void pressStart() {
		flipper.decrementCredit();
		flipper.transitionToPlaying();
	}
	
	@Override
	public void flipLeft() {
	
	}
	
	@Override
	public void flipRight() {
	
	}
}
