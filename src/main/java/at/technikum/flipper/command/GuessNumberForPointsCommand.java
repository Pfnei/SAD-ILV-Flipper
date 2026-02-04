package at.technikum.flipper.command;

import at.technikum.flipper.Flipper;

import java.util.Scanner;

public class GuessNumberForPointsCommand {
	
	private final int points;
	private final  GuessNumberCommand guessNumberCommand;
	
	public GuessNumberForPointsCommand(Scanner scanner, int lower, int upper, int points) {
		this.guessNumberCommand = new GuessNumberCommand(scanner, lower, upper);
		this.points=points;
	}
	
	public void execute(Flipper flipper) {
		guessNumberCommand.execute(flipper);
		if (guessNumberCommand.hasWon()) {
			System.out.printf("Gewonnen! +%d Punkte%n", points );
			new AddPointsCommand(this.points).execute(flipper);
		}
		System.out.println("Aktuelle Kredits: " + flipper.getCredits());
	}
}
