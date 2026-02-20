package at.technikum.flipper.command;

import at.technikum.flipper.Flipper;

import java.util.Scanner;

public class GuessNumberForPointsCommand implements Command {
	
	private final int points;
	private final  GuessNumberCommand guessNumberCommand;
	
	public GuessNumberForPointsCommand(Scanner scanner,  int points) {
		this.guessNumberCommand = new GuessNumberCommand(scanner);
		this.points=points;
	}
	
	public void execute(Flipper flipper) {
		guessNumberCommand.execute(flipper);
		if (guessNumberCommand.hasWon()) {
			System.out.printf("\nGewonnen! +%d Punkte%n", points );
			new AddPointsCommand(this.points).execute(flipper);
		}
	}
}
