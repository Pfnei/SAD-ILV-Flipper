package at.technikum.flipper.mediator;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.command.*;
import at.technikum.flipper.element.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Filter;


public class ElementMediator {
	
	
	private ArrayList<FlipperElement> elements;
	private ArrayList<Light> listOfLights = new ArrayList<>();
	protected final Flipper flipper;
	
	public ElementMediator(Flipper flipper) {
		this.flipper = flipper;
		this.elements = new ArrayList<>();
		this.setupElements();
		this.intializeLightList();
		
	}
	
	
	private void setupElements() {
		Scanner scanner = new Scanner(System.in);
		
		this.elements.add(new Bumper("Bumper1"));
		this.getELementByName("Bumper1").setHitCommand( new AddPointsAndToggleLightCommand(75));
		this.elements.add(new Light("Light1"));
		this.elements.add(new Bumper("Bumper2"));
		this.getELementByName("Bumper2").setHitCommand( new AddPointsAndToggleLightCommand(180));
		this.elements.add(new Bumper("Bumper3"));
		this.getELementByName("Bumper3").setHitCommand( new AddPointsAndToggleLightCommand(591));
		this.elements.add(new Light("Light2"));
		this.elements.add(new Light("Light3"));
		this.elements.add(new Light("Light4"));
		
		this.elements.add(new Target("Target-Red"));
		this.getELementByName("Target-Red").setHitCommand(new AddPointsCommand(100));
		
		this.elements.add(new Target("Target-Blue"));
		this.getELementByName("Target-Red").setHitCommand(new AddPointsCommand(150));
		
		this.elements.add (new Bumper("Bumper-4"));
		MacroCommand bumperMacro = new MacroCommand();
		bumperMacro.addCommand(new AddPointsCommand(50));
		bumperMacro.addCommand(new PlaySoundCommand("bumper.wav"));
		bumperMacro.addCommand( new GuessNumberForCreditCommand(scanner, 1, 1));
		this.getELementByName("Bumper-4").setHitCommand(bumperMacro);
		
		
		
		this.elements.add (new Hole("Mystery Hole"));
		MacroCommand holeMacro = new MacroCommand();
		holeMacro.addCommand(new AddPointsCommand(500));
		holeMacro.addCommand(new PlaySoundCommand("mystery.wav"));
		holeMacro.addCommand( new GuessNumberForPointsCommand(scanner, 1, 1,333));
		this.getELementByName("Mystery Hole").setHitCommand(holeMacro);
	}
	
	
	public FlipperElement getELementByName(String name) {
		for (FlipperElement e : elements) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		System.out.println("Unbekanntes Element: " + name);
		return null;
	}
	
	
	
	
	private void intializeLightList() {
		for (FlipperElement e : elements) {
			if (e instanceof Light) {
				listOfLights.add((Light) e);
			}
		}
	}
	
	public ArrayList<Light> getListOfLights() {
		return listOfLights;
	}
	
	public void hit(String name) {
		for (FlipperElement e : elements) {
			if (e.getName().equals(name)) {
				e.hit(flipper);
				return;
			}
		}
		System.out.println("Unbekanntes Element: " + name);
	}
	
	public void hit(int arrayIndex) {
		if (0 <= arrayIndex && arrayIndex < this.elements.size()) {
			this.elements.get(arrayIndex).hit(flipper);
		}
		else { System.out.println("ArrayIndex out of Bounds"); }
		return;
		
	}
	
	public void toogleLight(String name) {
		for (FlipperElement e : elements) {
			if (e.getName().equals(name)) {
				if (e instanceof Light) {
					e.hit(flipper);
				} else {
					System.out.println("Element: " + name + " is kein Light");
				}
				return;
			}
			
		}
		System.out.println("Unbekanntes Element: " + name);
	}
}
