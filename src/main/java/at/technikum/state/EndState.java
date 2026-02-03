package at.technikum.state;

import at.technikum.Flipper;

import java.util.Scanner;

public class EndState extends State {
	
	public EndState(Flipper flipper) {
		super(flipper);
		bonusGame();
	}
	
	public void bonusGame() {
		System.out.println("=== BONUS SPIEL ===");
		int guess = 0;
		while (true) {
			System.out.println("Rate eine Zahl zwischen 1 und 5:");
			System.out.print("> ");
			Scanner scanner = new Scanner(System.in);
			if (scanner.hasNextInt()) {
				guess = scanner.nextInt();
				break;
			} else {
				System.out.println("Fehler: Bitte eine GANZE Zahl eingeben!");
				scanner.next();
			}
		}
		int random = (int) (Math.random() * 5) + 1;
		if (guess == random) {
			System.out.println("Gewonnen! +1 Kredit");
			flipper.incrementCredit();
		} else {
			System.out.println("Verloren! Die Zahl war: " + random);
		}
		System.out.println("Aktuelle Kredits: " + flipper.getCredits());
		
		if (flipper.getCredits() > 0) {
			flipper.transitionToReady();
		} else {
			flipper.transitionToNoCredit();
		}
	}
	
	
	@Override
	public void pressStart() {
	
	}
	
	@Override
	public void flipLeft() {
	
	}
	
	@Override
	public void flipRight() {
	
	}
}
