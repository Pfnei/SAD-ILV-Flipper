package at.technikum.flipper.mediator;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.element.FlipperElement;
import at.technikum.flipper.element.Light;

import java.util.ArrayList;

public class AllLightsOnBonusMediator implements ElementMediator {
	
	private final Flipper flipper;
	private final ArrayList<Light> lights;
	private final int bonusPoints;
	
	public AllLightsOnBonusMediator(Flipper flipper, ArrayList<Light> lights, int bonusPoints) {
		this.flipper = flipper;
		this.lights = lights;
		this.bonusPoints = bonusPoints;
	}
	
	@Override
	public void onHit(FlipperElement element) {
		if (!(element instanceof Light)) return;
		
		for (Light l : lights) {
			if (!l.isOn()) return;
		}
		System.out.println("Bonuspunkte - alle Lichter sind an!");
		flipper.addScore(bonusPoints);
	}
}