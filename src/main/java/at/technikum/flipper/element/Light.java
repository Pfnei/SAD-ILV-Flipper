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
		if (hitCommand != null) hitCommand.execute(flipper);
		toggleLight();
		if (mediator != null) mediator.onHit(this);
	}
	
	
	public void toggleLight() {
		isOn = !isOn;
		if (isOn)
			System.out.println("Light " + name + " is on.");
		else
			System.out.println("Light " + name+ " is off.");
	}
	
	public boolean isOn() {
		return isOn;
	}
}
