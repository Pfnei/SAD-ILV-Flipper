package at.technikum.flipper.element;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.command.AddPointsCommand;
import at.technikum.flipper.visitor.FlipperElementVisitor;

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
	
	public void reset() {
		isOn = false;
		System.out.println("Light " + name + " ist aus.");
		System.out.println("Reset: " + name);
	}
	
	@Override
	public void accept(FlipperElementVisitor visitor) {
		visitor.visit(this);
	}
	
}
