package at.technikum.flipper.command;


import at.technikum.flipper.Flipper;
import at.technikum.flipper.element.Light;
import at.technikum.flipper.util.Util;

import java.util.ArrayList;

public class ToggleRandomLightCommand implements Command {
	
	public ToggleRandomLightCommand () {
	
	}
	
	public void execute(Flipper flipper) {
		ArrayList<Light> listOfLights = flipper.getElementMediator().getListOfLights();
		int sizeLightsList = listOfLights.size();
		int randomLight =  Util.randomInt(0,sizeLightsList-1);
		new ToggleLightCommand(listOfLights.get(randomLight).getName()).execute(flipper);
		
	}
	
	
}

