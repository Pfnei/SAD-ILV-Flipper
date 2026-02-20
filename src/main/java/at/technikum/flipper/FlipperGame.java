package at.technikum.flipper;

import at.technikum.flipper.element.*;
import at.technikum.flipper.state.NoCreditState;
import at.technikum.flipper.util.InputUtil;
import at.technikum.flipper.visitor.*;

import static at.technikum.flipper.util.InputUtil.askForLeftRight;
import static at.technikum.flipper.util.Util.randomInt;

public class FlipperGame {
	
	private final Flipper flipper;
	
	public FlipperGame() {
		this.flipper = new Flipper();
	}
	
	public static void main(String[] args) {
		FlipperGame game = new FlipperGame();
		game.play();
	}
	
	
	public void play() {
		
		System.out.println("\n=== FLIPPER GAME ===\n");
		
		do {
			
			int fontSelect = InputUtil.askForInt("Wähle eine Schrift für das Game:\n" +
					"  (1) Digital\n" +
					"  (2) Epic\n" +
					"  (3) Nancyj Underlined\n", 1, 3);
			
			
			switch (fontSelect) {
				case 1:
					flipper.useDigitalFont();
					break;
				case 2:
					flipper.useEpicFont();
					break;
				case 3:
					flipper.useNancyjUnderlinedFont();
					break;
				default:
			}
			
			System.out.println("Du hast gewählt: " + fontSelect);
			
			System.out.println("\nDu hast: " + flipper.getCredits() + " Credits! \n");
			
			int chooseAction = InputUtil.askForInt("Was willst du machen:\n" +
					"  (1) Spiel starten\n" +
					"  (2) Münze einwerfen & Spiel starten\n"					+
					"  (3) 2! Münze einwerfen & Spiel starten\n", 1, 2);
			
			switch (chooseAction) {
				case 1:
					flipper.pressStart();
					break;
				case 2:
					flipper.insertCoin();
					flipper.pressStart();
					break;
				case 3:
					flipper.insertCoin();
					flipper.insertCoin();
					flipper.pressStart();
					break;
				default:
			}
			
			// Autor anzeigen
			flipper.pressStart();
			
			// hier könnte man Standardelemente Testen
			//testElements()
			
			
			flipper.showGameRunning();
			flipper.showRandomHits();
			
			 int oldBalls = flipper.getRemainingBalls();
			flipper.showBall();
			System.out.println("\n--- Ball ist im Spiel und trifft zufällig Elemente ---\n");
			do {
				
				if (oldBalls != flipper.getRemainingBalls()) {
					flipper.showBall();
					System.out.println("\n--- Ball ist im Spiel und trifft zufällig Elemente ---\n");
				}
				
				  oldBalls = flipper.getRemainingBalls();
				
				 int l = randomInt (1,6);
				 int u = randomInt (6,12);
				 int hits = randomInt (l,u);
				
				for (int i = 0; i < hits; i++) {
					flipper.hitRandomElement();
				}
				
				String flip = askForLeftRight ("\nLinken oder Rechten Flipper betätigen (L/R)?");
				
				
				if (flip.equals("l") ){flipper.flipLeft();}
				if (flip.equals("r") ){flipper.flipRight();}
				
			} while (flipper.getRemainingBalls()>0);
			flipper.endGame();
			
			//  resetElements();
			
			
			System.out.println("\n--- Random Hits ---\n");
			
			for (int i = 0; i < 5; i++) {
				flipper.hitRandomElement();
			}
			
			System.out.println("\n--- Bälle verlieren ---\n");
			
			flipper.flipLeft();
			this.startPointsVisitor();
			flipper.flipLeft();
			this.startPointsVisitor();
			flipper.flipLeft();
			this.startPointsVisitor();
			
			// flipper.loseBall();
			// flipper.loseBall();
			//flipper.loseBall();
			
			
		} while (flipper.getRemainingBalls()>0);
	}
	
	
	
	public void resetElements() {
		
		System.out.println("\n--- RESET Elements ---\n");
		
		ResetVisitor resetVisitor = new ResetVisitor();
		for (FlipperElement e : flipper.getElements()) {
			e.accept(resetVisitor);
		}
	}
	
	public void startPointsVisitor() {
		System.out.println("\n--- ZUSATZPUNKTVERGABE ---\n");
		AdditionalPointsVisitor v = new AdditionalPointsVisitor(flipper);
		for (FlipperElement e : flipper.getElements()) {
			e.accept(v);
		}
		int bonus = v.getTotal();
		System.out.println("Zusatzpunkte: " + bonus);
		flipper.addScore(bonus);
	}
	
	
	public void testElements() {
		System.out.println("\n--- Test von ein paar Standardfunktionlitäten ---\n");
		
		flipper.getElementMediator().hit("Ramp-1");
		flipper.getElementMediator().hit("Bumper-4");
		flipper.getElementMediator().hit(2);
		flipper.getElementMediator().hit(1);
		flipper.getElementMediator().hit("Ramp-1");
		flipper.getElementMediator().hit("Mystery Hole");
		flipper.getElementMediator().hit("Target-Red");
		flipper.getElementMediator().hit("Light-1");
		flipper.getElementMediator().hit("Light-2");
		flipper.getElementMediator().hit("Light-3");
		flipper.getElementMediator().hit("Light-4");
		
	}
}

