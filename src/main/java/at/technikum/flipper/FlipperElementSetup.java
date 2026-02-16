package at.technikum.flipper;

import at.technikum.flipper.command.*;
import at.technikum.flipper.element.*;
import at.technikum.flipper.mediator.ElementMediatorClass;

import java.util.Scanner;

public class FlipperElementSetup {
	
	public void setupElements(ElementMediatorClass mediator) {
		Scanner scanner = new Scanner(System.in);
		
		Bumper bumper1 = new Bumper("Bumper1");
		bumper1.setHitCommand(new AddPointsAndToggleLightCommand(75));
		mediator.addElement(bumper1);
		
		Light light1 = new Light("Light1");
		light1.setHitCommand(new AddPointsDependingOnLightCommand(light1, 50, 1000));
		mediator.addElement(light1);
		
		Bumper bumper2 = new Bumper("Bumper2");
		bumper2.setHitCommand(new AddPointsAndToggleLightCommand(180));
		mediator.addElement(bumper2);
		
		Bumper bumper3 = new Bumper("Bumper3");
		bumper3.setHitCommand(new AddPointsAndToggleLightCommand(591));
		mediator.addElement(bumper3);
		
		Light light2 = new Light("Light2");
		light1.setHitCommand(new AddPointsDependingOnLightCommand(light1, 50, 1000));
		mediator.addElement(light2);
		
		Light light3 = new Light("Light3");
		light1.setHitCommand(new AddPointsDependingOnLightCommand(light1, 50, 1000));
		mediator.addElement(light3);
		
		Light light4 = new Light("Light4");
		light1.setHitCommand(new AddPointsDependingOnLightCommand(light1, 50, 1000));
		mediator.addElement(light4);
		
		Target targetRed = new Target("Target-Red");
		targetRed.setHitCommand(new AddPointsCommand(100));
		mediator.addElement(targetRed);
		
		Target targetBlue = new Target("Target-Blue");
		targetBlue.setHitCommand(new AddPointsCommand(150));
		mediator.addElement(targetBlue);
		
		Bumper bumper4 = new Bumper("Bumper-4");
		MacroCommand bumperMacro = new MacroCommand();
		bumperMacro.addCommand(new AddPointsCommand(50));
		bumperMacro.addCommand(new PlaySoundCommand("bumper.wav"));
		bumperMacro.addCommand(new GuessNumberForCreditCommand(scanner, 1, 3));
		bumper4.setHitCommand(bumperMacro);
		mediator.addElement(bumper4);
		
		Hole mysteryHole = new Hole("Mystery Hole");
		MacroCommand holeMacro = new MacroCommand();
		holeMacro.addCommand(new AddPointsCommand(500));
		holeMacro.addCommand(new PlaySoundCommand("mystery.wav"));
		holeMacro.addCommand(new GuessNumberForPointsCommand(scanner, 1, 4, 333));
		mysteryHole.setHitCommand(holeMacro);
		mediator.addElement(mysteryHole);
	}
	
	
}
