package at.technikum.flipper.mediator;

import at.technikum.flipper.Flipper;

import at.technikum.flipper.element.*;
import java.util.ArrayList;



public class ElementMediatorClass implements ElementMediator {
	
	
	private ArrayList<FlipperElement> elements = new ArrayList<>();;
	private ArrayList<Light> listOfLights = new ArrayList<>();
	protected final Flipper flipper;
	
	public ElementMediatorClass(Flipper flipper) {
		this.flipper = flipper;
	}
	
	@Override
	public void onHit(FlipperElement element) {
	}
	
	public void addElement(FlipperElement element) {
		elements.add(element);
		if (element.getMediator() == null) element.setMediator((ElementMediator) this);
		if (element instanceof Light l) listOfLights.add(l);
	}
	
	
	public FlipperElement getELementByName(String name) {
		for (FlipperElement e : elements) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		System.out.println("Unbekanntes Element: " + name);
		return null;
	}
	
	public ArrayList<Light> getListOfLights() {
		return listOfLights;
	}
	
	
	
	public void hit(String name) {
		FlipperElement e = getELementByName(name);
		if (e != null) e.hit(flipper);
	}
	
	public void hit(int arrayIndex) {
		if (0 <= arrayIndex && arrayIndex < this.elements.size()) {
			this.elements.get(arrayIndex).hit(flipper);
		}
		else { System.out.println("ArrayIndex out of Bounds"); }
		return;
		
	}
	
	
	
	
	
	public void toogleLight(String name) {
		for (FlipperElement e : elements) {
			if (e.getName().equals(name)) {
				if (e instanceof Light) {
					e.hit(flipper);
				} else {
					System.out.println("Element: " + name + " is kein Light");
				}
				return;
			}
			
		}
		System.out.println("Unbekanntes Element: " + name);
	}
	

	
	
	
	

	
	
}
