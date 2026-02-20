package at.technikum.flipper.command;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.util.Util;

import java.util.Scanner;

public class GuessNumberForCreditCommand implements Command {
	
	GuessNumberCommand guessNumberCommand;
	
	public GuessNumberForCreditCommand(Scanner scanner) {
		this.guessNumberCommand = new GuessNumberCommand(scanner);
	}
	
	public void execute(Flipper flipper) {
		guessNumberCommand.execute(flipper);
		if (guessNumberCommand.hasWon()) {
			System.out.println("Gewonnen! +1 Kredit");
			flipper.addCredit();
			System.out.println("Aktuelle Kredits: " + flipper.getCredits());
		}
		
	}
}

