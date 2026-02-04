package at.technikum.flipper.mediator;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.element.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;


public class ElementMediator {
	
	
	private ArrayList<FlipperElement> elements;
	private ArrayList<Light> listOfLights = new ArrayList<>();
	protected final Flipper flipper;
	
	public ElementMediator(Flipper flipper) {
		this.flipper = flipper;
		this.elements = new ArrayList<>();
		this.elements.add(new Bumper("Bumper1"));
		this.elements.add(new Light("Light1"));
		this.elements.add(new Bumper("Bumper2"));
		this.elements.add(new Bumper("Bumper3"));
		this.elements.add(new Light("Light2"));
		this.elements.add(new Light("Light3"));
		this.elements.add(new Light("Light4"));
		
		this.intializeLightList();
		
	}
	
	
	private void intializeLightList() {
		for (FlipperElement e : elements) {
			if (e instanceof Light) {
				listOfLights.add((Light) e);
			}
		}
	}
	
	public ArrayList<Light> getListOfLights() {
		return listOfLights;
	}
	
	public void hit(String name) {
		for (FlipperElement e : elements) {
			if (e.getName().equals(name)) {
				e.hit(flipper);
				return;
			}
		}
		System.out.println("Unbekanntes Element: " + name);
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
