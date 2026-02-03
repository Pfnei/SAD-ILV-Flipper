package at.technikum;

import at.technikum.state.*;

public class Flipper {
	private State state;
	private int credits;
	
	Flipper() {this.state = new NoCreditState(this);}
	
	
	public void transitionToReady() {
		this.state = new ReadyState(this);
		System.out.println("Neuer Zustand: Ready-Zustand");
	}
	
	public void transitionToPlaying() {
		this.state = new PlayingState(this);
		System.out.println("Neuer Zustand: Playing-Zustand");
	}
	
	public void transitionToNoCredit() {
		this.state = new NoCreditState(this);
		System.out.println("Neuer Zustand: NoCredit-Zustand");
	}
	
	public void transitionToEndState() {
		System.out.println("Neuer Zustand: EndState!");
		this.state = new EndState(this);
	}
	
	
	public void incrementCredit() {
		credits++;
	}
	
	public void decrementCredit() {
		credits--;
	}
	
	public int getCredits() {
		return this.credits;
	}
	
	public State getState() {
		return this.state;
	}
}
