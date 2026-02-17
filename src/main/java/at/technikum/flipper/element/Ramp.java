package at.technikum.flipper.element;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.visitor.FlipperElementVisitor;

public class Ramp extends FlipperElement {
	
	private boolean isOpen = false;
	private int passCount= 0;
	
	public Ramp(String name) {
		super(name);
	}
	
	@Override
	public void hit(Flipper flipper) {
		if (!isOpen) {
			System.out.println("Rampe " + name + " ist nicht offen!");
		} else {
			passCount++;
			System.out.println("Rampe " + name + " wird zum " + passCount + ". durchlaufen") ;
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
	
	public void reset() {
		isOpen = false;
		passCount= 0;
		System.out.println("Ramp " + name + " ist wieder geschlossen!");
		System.out.println("Reset: " + name);
	}
	
	@Override
	public void accept(FlipperElementVisitor visitor) {
		visitor.visit(this);
	}
	
	
}
