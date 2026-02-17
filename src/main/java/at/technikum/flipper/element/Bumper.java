package at.technikum.flipper.element;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.command.AddPointsCommand;
import at.technikum.flipper.command.ToggleLightCommand;
import at.technikum.flipper.command.ToggleRandomLightCommand;
import at.technikum.flipper.util.Util;
import at.technikum.flipper.visitor.FlipperElementVisitor;

import java.util.ArrayList;

public class Bumper extends FlipperElement {
	
	private int hitCount = 0;
	
	public Bumper(String name) {
		super(name);
	}
	
	@Override
	public void hit(Flipper flipper) {
		hitCount++;
		System.out.println("Bumper " + name + " wird zum " + hitCount + ". getroffen");
		super.hit(flipper);
		
	}
	public void reset() {
		hitCount= 0;
		System.out.println("Reset: " + name);
	}
	
	public int getHitCount () {
		return hitCount;
	}
	
	@Override
	public void accept(FlipperElementVisitor visitor) {
		visitor.visit(this);
	}
	
}