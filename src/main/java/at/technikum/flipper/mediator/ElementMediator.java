package at.technikum.flipper.mediator;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.element.*;

import java.util.ArrayList;


public class ElementMediator {
	
	
	private Element[] elements;
	private ArrayList<Integer> listOfLightIDs = new ArrayList<>();
	protected final Flipper flipper;
	
	public ElementMediator(Flipper flipper) {
		this.flipper = flipper;
		this.elements = new Element[]
				
				{
						new Bumper(1),
						new Light (2),
						new Bumper(3),
						new Bumper(4),
						new Light (5),
						new Light (6),
						new Light (7)
						
				};
		this.intializeLightIDList();
		
	}
	
	
	private void intializeLightIDList() {
		for (Element e : elements) {
			if (e.getType().equals("light")) {
				listOfLightIDs.add(e.getId());		}
		}
	}
	public ArrayList<Integer> getListOfLightIDs() {
		return listOfLightIDs;
	}
	
	public void hit(int elementId) {
		for (Element e : elements) {
			if (e.getId() == elementId) {
				e.hit (flipper);
				return;
			}
		}
		System.out.println("Unbekanntes Element: " + elementId);
	}
	
	public void toogleLight(int elementId) {
		for (Element e : elements) {
			if (e.getId() == elementId) {
				if (e.getType().equals("light")) {
				e.hit (flipper);}
				else {
					System.out.println("Element: " + elementId + " is kein Light");
				}
					return;
				}
			
		}
		System.out.println("Unbekanntes Element: " + elementId);
	}
}
