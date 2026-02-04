package at.technikum.flipper.command;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.util.Util;

import java.util.Scanner;

public class GuessNumberCommand implements Command {
	private final Scanner scanner;
	private final int correctNumber;
	private boolean won;
	private final int lower;
	private final int upper;
	
	public GuessNumberCommand(Scanner scanner, int lower, int upper) {
		this.scanner = scanner;
		this.lower = lower;
		this.upper = upper;
		this.correctNumber = Util.randomInt(lower, upper);
		this.won = false;
	}
	
	@Override
	public void execute(Flipper flipper) {
		System.out.println("=== BONUS SPIEL ===");
		int guess = 0;
		while (true) {
			System.out.printf("Rate eine Zahl (%d-%d):", lower, upper);
			System.out.print("> ");
			if (scanner.hasNextInt()) {
				guess = scanner.nextInt();
				break;
			} else {
				System.out.println("Fehler: Bitte eine GANZE Zahl eingeben!");
				scanner.next();
			}
		}
		if (guess == correctNumber) {
			System.out.println("RICHTIG!");
			won = true;
		} else {
			System.out.println("FALSCH! Die Zahl war " + correctNumber);
			won = false;
		}
	}
	
	
	public boolean hasWon() {
		return won;
	}
	
}
