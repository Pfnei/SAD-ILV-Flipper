package at.technikum.flipper;

import at.technikum.flipper.command.*;
import at.technikum.flipper.element.*;
import at.technikum.flipper.mediator.AllLightsOnBonusMediator;
import at.technikum.flipper.mediator.ElementMediatorHub;
import at.technikum.flipper.mediator.TargetGroupRampMediator;

import java.util.Scanner;

public class FlipperElementSetup {
	
	public void setupElements(ElementMediatorHub mediator) {
		Scanner scanner = new Scanner(System.in);
		
		Ramp ramp1 = new Ramp("Ramp-1");
		ramp1.setHitCommand(new AddPointsCommand(2000));
		mediator.addBaseElement(ramp1);
		
		Target targetRed = new Target("Target-Red");
		targetRed.setHitCommand(new AddPointsCommand(100));
		mediator.addMediatedElement(targetRed);
		
		Target targetBlue = new Target("Target-Blue");
		targetBlue.setHitCommand(new AddPointsCommand(150));
		mediator.addMediatedElement(targetBlue);
		
		
		
		
		
		
		Bumper bumper1 = new Bumper("Bumper-1");
		bumper1.setHitCommand(new AddPointsAndToggleLightCommand(75));
		mediator.addBaseElement(bumper1);
		
		Light light1 = new Light("Light-1");
		light1.setHitCommand(new AddPointsDependingOnLightCommand(light1, 50, 1000));
		mediator.addMediatedElement(light1);
		
		Bumper bumper2 = new Bumper("Bumper-2");
		bumper2.setHitCommand(new AddPointsAndToggleLightCommand(180));
		mediator.addBaseElement(bumper2);
		
		Bumper bumper3 = new Bumper("Bumper-3");
		bumper3.setHitCommand(new AddPointsAndToggleLightCommand(591));
		mediator.addBaseElement(bumper3);
		
		Light light2 = new Light("Light-2");
		light2.setHitCommand(new AddPointsDependingOnLightCommand(light2, 50, 1000));
		mediator.addMediatedElement(light2);
		
		Light light3 = new Light("Light-3");
		light3.setHitCommand(new AddPointsDependingOnLightCommand(light3, 50, 1000));
		mediator.addMediatedElement(light3);
		
		Light light4 = new Light("Light-4");
		light4.setHitCommand(new AddPointsDependingOnLightCommand(light4, 50, 1000));
		mediator.addMediatedElement(light4);
		
		
		
		Bumper bumper4 = new Bumper("Bumper-4");
		MacroCommand bumperMacro = new MacroCommand();
		bumperMacro.addCommand(new AddPointsCommand(50));
		bumperMacro.addCommand(new PlaySoundCommand("bumper.wav"));
		bumperMacro.addCommand(new GuessNumberForCreditCommand(scanner, 1, 3));
		bumper4.setHitCommand(bumperMacro);
		mediator.addBaseElement(bumper4);
		
		Hole mysteryHole = new Hole("Mystery Hole");
		MacroCommand holeMacro = new MacroCommand();
		holeMacro.addCommand(new AddPointsCommand(500));
		holeMacro.addCommand(new PlaySoundCommand("mystery.wav"));
		holeMacro.addCommand(new GuessNumberForPointsCommand(scanner, 1, 4, 333));
		mysteryHole.setHitCommand(holeMacro);
		mediator.addBaseElement(mysteryHole);
	}
	
	
	public void setupGroups(ElementMediatorHub mediator, Flipper flipper) {
		Ramp ramp = (Ramp) mediator.getELementByName("Ramp-1");
		Target red = (Target) mediator.getELementByName("Target-Red");
		Target blue = (Target) mediator.getELementByName("Target-Blue");
		
		mediator.addRule(new TargetGroupRampMediator(ramp, red, blue));
		mediator.addRule(new AllLightsOnBonusMediator(flipper, mediator.getListOfLights(), 500));
	}
}
