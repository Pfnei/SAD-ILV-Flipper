package at.technikum;

import at.technikum.state.*;

public class Flipper {
	private State state;
	private int credits;
	
	Flipper() {
	
	}
	
	public void incrementCredits() {
		credits++;
	}
	
	public void decrementCredits() {
		credits--;
	}
}
