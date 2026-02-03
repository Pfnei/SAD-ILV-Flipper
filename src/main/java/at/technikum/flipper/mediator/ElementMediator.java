package at.technikum.flipper.mediator;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.element.Bumper;
import at.technikum.flipper.element.Element;


public class ElementMediator {
	
	
	private Element[] elements;
	protected final Flipper flipper;
	
	public ElementMediator(Flipper flipper) {
		this.flipper = flipper;
		this.elements = new Element[]
				
				{
						new Bumper(1),
						new Bumper(2),
						new Bumper(3),
				};
		
		
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
}
