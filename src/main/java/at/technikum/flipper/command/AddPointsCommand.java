package at.technikum.flipper.command;

import at.technikum.flipper.Flipper;

public class AddPointsCommand implements Command {
	
	private int newPoints;
	
	public AddPointsCommand (int newPoints) {
		this.newPoints = newPoints;
		
	}
	
	public void execute(Flipper flipper) {
		flipper.addScore(this.newPoints);
	}
	
}
