package at.technikum.flipper.element;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.command.AddPointsCommand;
import at.technikum.flipper.command.Command;
import at.technikum.flipper.command.ToggleLightCommand;

public class Bumper implements Element {
	private final int id;
	
	public Bumper(int id) {
		this.id = id;
	}
	
	@Override public int getId() {	return id;}
	@Override public String getType() {	return "bumper";}
	
	@Override
	public void hit(Flipper flipper) {
		System.out.println("Hit Bumper " + id);
		new AddPointsCommand(100*id).execute(flipper);
		new ToggleLightCommand(4).execute(flipper);
	}
}