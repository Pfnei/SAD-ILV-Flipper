package at.technikum.flipper.command;

import at.technikum.flipper.Flipper;

public class AddPointsAndToggleLightCommand implements Command {
	
	private int newPoints;
	
	public AddPointsAndToggleLightCommand (int newPoints) {
		this.newPoints = newPoints;
		
	}
	
	public void execute(Flipper flipper) {
		flipper.addScore(this.newPoints);
		new ToggleRandomLightCommand().execute(flipper);
	}
	
}