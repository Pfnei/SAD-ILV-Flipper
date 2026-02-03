package at.technikum.flipper;

import at.technikum.flipper.mediator.ElementMediator;
import at.technikum.flipper.state.*;
import at.technikum.flipper.element.*;

public class Flipper {
	private State state;
	private int credits;
	private int score;
	private int remainingBalls;
	private static final int MAX_BALLS = 3;
	private ElementMediator elementMediator;
	
	Flipper() {
		this.state = new NoCreditState(this);
		this.remainingBalls =  MAX_BALLS;
		this.elementMediator =  new ElementMediator (this);
	}
	
	public static void main(String[] args) {
		Flipper flipper = new Flipper();
		flipper.play();
	}
	
	public void play() {
		System.out.println("=== FLIPPER GAME ===\n");
		
		pressStart();
		insertCoin();
		pressStart();
		flipLeft();
		insertCoin();
		flipRight();
		pressStart();
		flipLeft();
		elementMediator.hit(2);
		elementMediator.hit(1);
		elementMediator.hit(3);
		flipLeft();
		
		
		
	}
	
	
	
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
	
	
	
	
	
	
	public void decrementRemainingBalls() {remainingBalls--;}
	public int getRemainingBalls() {return this.remainingBalls;};
	
	public void addCredit() {credits++;}
	
	public void useOneCredit() {credits--;}
	
	public int getCredits() {return this.credits;}
	
	public void addScore(int points) {
		score += points;
		System.out.println("Score +" + points + " => " + score);
	}
	
	public State getState() {return this.state;}
	
	public void pressStart() {state.pressStart();}
	
	public void insertCoin() {state.insertCoin();}
	
	public void flipLeft() {state.flipLeft();}
	
	public void flipRight() {state.flipRight();}
}
