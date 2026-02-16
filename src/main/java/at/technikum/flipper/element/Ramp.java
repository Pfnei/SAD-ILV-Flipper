package at.technikum.flipper.element;

import at.technikum.flipper.Flipper;

public class Ramp extends FlipperElement {
	
	private boolean isOpen = false;
	
	public Ramp(String name) {
		super(name);
	}
	
	@Override
	public void hit(Flipper flipper) {
		if (!isOpen) {
			System.out.println("Rampe " + name + " ist nicht offen!");
		} else {
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
		System.out.println("Ramp " + name + " ist wieder geschlossen!");
	}
	
	
}
