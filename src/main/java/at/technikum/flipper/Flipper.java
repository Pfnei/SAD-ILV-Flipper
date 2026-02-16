package at.technikum.flipper;

import at.technikum.flipper.element.*;
import at.technikum.flipper.mediator.AllLightsOnBonusMediator;
import at.technikum.flipper.mediator.ElementMediatorHub;
import at.technikum.flipper.mediator.TargetGroupRampMediator;
import at.technikum.flipper.state.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Flipper {
	private State state;
	private int credits;
	private int score;
	private int remainingBalls;
	private static final int MAX_BALLS = 3;
	
	private ElementMediatorHub elementMediator;
	private  ArrayList<FlipperElement> elements;
	
	Flipper() {
		this.state = new NoCreditState(this);
		this.remainingBalls =  MAX_BALLS;
		this.elementMediator =  new ElementMediatorHub(this);
		FlipperElementSetup setup = new FlipperElementSetup();
		setup.setupElements(this.elementMediator);
		setup.setupGroups(this.elementMediator, this);
		
		this.elements = this.elementMediator.getElements();
		
	}
	
	public ElementMediatorHub getElementMediator() {return this.elementMediator;}
	
	public ArrayList<FlipperElement> getElements() {
		return this.elements;
	}
	
	public void hitRandomElement() {
		if (elements.isEmpty()) return;
		int idx = ThreadLocalRandom.current().nextInt(elements.size());
		elements.get(idx).hit(this);
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
