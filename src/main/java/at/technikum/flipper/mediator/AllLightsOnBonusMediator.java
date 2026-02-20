package at.technikum.flipper.mediator;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.command.*;
import at.technikum.flipper.element.FlipperElement;
import at.technikum.flipper.element.Hole;
import at.technikum.flipper.element.Light;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllLightsOnBonusMediator implements ElementMediator {
	
	private final Flipper flipper;
	private final List<Light> lights;
	private final int bonusPoints;
	private final Scanner scanner;
	
	public AllLightsOnBonusMediator(Flipper flipper, List<Light> lights, int bonusPoints, Scanner scanner) {
		this.flipper = flipper;
		this.lights = lights;
		this.bonusPoints = bonusPoints;
		this.scanner = scanner;
	}
	
	
	@Override
	public void onHit(FlipperElement element) {
		if (!(element instanceof Light)) return;
		
		for (Light l : lights) {
			if (!l.isOn()) return;
		}
		System.out.println("Bonuspunkte - alle Lichter sind an!");
		flipper.addScore(bonusPoints);
		new GuessNumberForCreditCommand(scanner).execute(flipper);
		
		
	}
}