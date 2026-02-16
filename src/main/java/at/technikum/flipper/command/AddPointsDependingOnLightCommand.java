package at.technikum.flipper.command;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.element.Light;

public class AddPointsDependingOnLightCommand implements Command {
	
	private final Light light;
	private final int pointsIfOff;
	private final int pointsIfOn;
	
	public AddPointsDependingOnLightCommand(Light light, int pointsIfOff, int pointsIfOn) {
		this.light = light;
		this.pointsIfOff = pointsIfOff;
		this.pointsIfOn = pointsIfOn;
	}
	
	@Override
	public void execute(Flipper flipper) {
		if (light.isOn()) {
			new AddPointsCommand(pointsIfOn).execute(flipper);
		} else {
			new AddPointsCommand(pointsIfOff).execute(flipper);
		}
	}
}