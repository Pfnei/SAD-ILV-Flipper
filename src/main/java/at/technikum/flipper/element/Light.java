package at.technikum.flipper.element;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.command.AddPointsCommand;

public class Light implements Element {
	private final int id;
	private boolean isOn;
	
	public Light(int id) {
		this.id = id;
		this.isOn = false;
	}
	
	
	
	@Override
	public int getId() {return id;}
	
	@Override
	public String getType() {return "light";}
	
	@Override
	public void hit(Flipper flipper) {
		System.out.println("Hit Light " + id);
		if (isOn) {
			System.out.println("Checkpot!!!");
			new AddPointsCommand((int) (10 * Math.pow((double) id, (double) id))).execute(flipper);
		}
		else {new AddPointsCommand(50).execute(flipper);}
		this.toogleLight();
	}
	
	public void toogleLight() {
		isOn = !isOn;
		if (isOn)
			System.out.println("Light " + id + " is on.");
		else
			System.out.println("Light " + id + " is off.");
	}
	
}
