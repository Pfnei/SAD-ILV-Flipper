package at.technikum.flipper.element;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.visitor.FlipperElementVisitor;

public class Ramp extends FlipperElement {
	
	private boolean isOpen = false;
	private int runCount= 0;
	
	public Ramp(String name) {
		super(name);
	}
	
	
	public void crash(Flipper flipper) {
		if (!isOpen) {
			System.out.println("Rampe " + name + " ist nicht offen!");
		} else {
			runCount++;
			System.out.println("Rampe " + name + " wird zum " + runCount + ". durchlaufen") ;
			super.hit(flipper);
		}
	}
	
	public void openRamp() {
		isOpen = true;
		System.out.println("Rampe " + name + " wurde geöffnet!");
	}
	
	public void closeRamp() {
		isOpen = false;
		System.out.println("Rampe " + name + " wurde geschlossen!");
	}
	
	public boolean isOpen() {
		return isOpen;
	}
	
	public int getRuns(){
		return runCount;
	}
	
	
	public void reset() {
		isOpen = false;
		runCount= 0;
		System.out.println("Ramp " + name + " ist wieder geschlossen!");
		System.out.println("Reset: " + name);
	}
	
	@Override
	public void accept(FlipperElementVisitor visitor) {
		visitor.visit(this);
	}
	
	
}
