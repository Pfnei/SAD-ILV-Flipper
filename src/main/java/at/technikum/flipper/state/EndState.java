package at.technikum.flipper.state;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.command.GuessNumberCommand;
import at.technikum.flipper.command.GuessNumberForCreditCommand;
import at.technikum.flipper.command.GuessNumberForPointsCommand;
import at.technikum.flipper.util.Util;

import java.util.Scanner;

public class EndState extends State {
	
	public EndState(Flipper flipper) {
		super(flipper);
		bonusGame();
	}
	
	public void bonusGame() {
		Scanner scanner = new Scanner(System.in);
		
		new GuessNumberForCreditCommand(scanner).execute(flipper);
		//new GuessNumberForPointsCommand(scanner, 1, 1, 100).execute(flipper);
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
