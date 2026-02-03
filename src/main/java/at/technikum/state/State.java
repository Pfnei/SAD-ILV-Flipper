package at.technikum.state;

import at.technikum.Flipper;

public abstract class State {
	protected Flipper flipper;
	
	public State(Flipper flipper) {
		this.flipper = flipper;
	}
	
	public abstract void pressStart();
	public abstract void flipLeft();
	public abstract void flipRight();
	
	public void insertCoin() {
		this.flipper.incrementCredit();
		if (flipper.getState() instanceof NoCreditState) {
			flipper.transitionToReady();
		}
		else {
			System.out.println("Kredit erhöht auf: " + flipper.getCredits());
		}
	}
	
	public Flipper getFlipper() {
		return flipper;
	}
}


