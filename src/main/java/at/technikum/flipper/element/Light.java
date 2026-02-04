package at.technikum.flipper.element;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.command.AddPointsCommand;

public class Light extends FlipperElement {
	
	private boolean isOn;
	

	public Light(String name) {
		super(name);
		this.isOn = false;
	}
	
	@Override
	public void hit(Flipper flipper) {
		System.out.println("Hit Light " + name);
		if (isOn) {
			System.out.println("Checkpot!!!");
			new AddPointsCommand(1000).execute(flipper);
			//new AddPointsCommand((int) (10 * Math.pow((double) id, (double) id))).execute(flipper);
		}
		else {new AddPointsCommand(50).execute(flipper);}
		this.toogleLight();
	}
	
	public void toogleLight() {
		isOn = !isOn;
		if (isOn)
			System.out.println("Light " + name + " is on.");
		else
			System.out.println("Light " + name+ " is off.");
	}
}
