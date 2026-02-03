package at.technikum.state;

import at.technikum.Flipper;

public abstract class State {
	private Flipper flipper;
	
	public State(Flipper flipper) {
		this.flipper = flipper;
	}
	
	public abstract void pressStart();
	public abstract void flipLeft();
	public abstract void flipRight();
	
	public void insertCoin() {
		this.flipper.incrementCredits();
	}
	
	public Flipper getFlipper() {
		return flipper;
	}
}


