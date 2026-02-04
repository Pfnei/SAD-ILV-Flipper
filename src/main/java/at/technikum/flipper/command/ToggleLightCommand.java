package at.technikum.flipper.command;

import at.technikum.flipper.Flipper;

public class ToggleLightCommand implements Command {
	
	private String elementName;
	
	public ToggleLightCommand (String elementName) {
		this.elementName = elementName;
		
	}
	
	public void execute(Flipper flipper) {
	  flipper.getElementMediator().toogleLight(elementName);
	}
	
	
}
