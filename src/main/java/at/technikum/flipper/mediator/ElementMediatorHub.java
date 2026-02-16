package at.technikum.flipper.mediator;

import at.technikum.flipper.Flipper;

import at.technikum.flipper.element.*;
import java.util.ArrayList;



public class ElementMediatorHub implements ElementMediator {
	
	
	private final ArrayList<FlipperElement> elements = new ArrayList<>();;
	private final ArrayList<Light> listOfLights = new ArrayList<>();
	private final ArrayList<ElementMediator> rules = new ArrayList<>();
	protected final Flipper flipper;
	
	public ElementMediatorHub(Flipper flipper) {
		this.flipper = flipper;
	}
	
	public void addRule(ElementMediator rule) {
		rules.add(rule);
	}
	
	
	public void addBaseElement(FlipperElement element) {
		elements.add(element);
		if (element instanceof Light l) listOfLights.add(l);
	}
	
	public void addMediatedElement(FlipperElement element) {
		elements.add(element);
		if (element.getMediator() == null) element.setMediator(this);
		if (element instanceof Light l) listOfLights.add(l);
	}
	
	public ArrayList<FlipperElement> getElements() {
		return elements;
	}
	
	public ArrayList<Light> getListOfLights() {
		return listOfLights;
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
	
	
	@Override
	public void onHit(FlipperElement element) {
		for (ElementMediator r : rules) {
			r.onHit(element);
		}
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
