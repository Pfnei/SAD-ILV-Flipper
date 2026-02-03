package at.technikum.flipper.state;

import at.technikum.flipper.Flipper;

public abstract class State {
	protected Flipper flipper;
	
	public State(Flipper flipper) {
		this.flipper = flipper;
	}
	
	public abstract void pressStart();
	public abstract void flipLeft();
	public abstract void flipRight();
	
	public void insertCoin() {
		this.flipper.addCredit();
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


