package at.technikum.flipper.command;

import at.technikum.flipper.Flipper;

public class ToggleLightCommand implements Command {
	
	private int elementId;
	
	public ToggleLightCommand (int elementId) {
		this.elementId = elementId;
		
	}
	
	public void execute(Flipper flipper) {
	  flipper.getElementMediator().toogleLight(elementId);
	}
	
	
}
