package at.technikum.flipper.element;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.command.AddPointsCommand;
import at.technikum.flipper.command.Command;
import at.technikum.flipper.command.ToggleLightCommand;
import at.technikum.flipper.util.Util;

import java.util.ArrayList;

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
		ArrayList<Integer> listOfLightIDs = flipper.getElementMediator().getListOfLightIDs();
		int sizeLightsList = listOfLightIDs.size();
		int randomLight =  Util.randomInt(0,sizeLightsList-1);
		new ToggleLightCommand(listOfLightIDs.get(randomLight)).execute(flipper);
	}
}