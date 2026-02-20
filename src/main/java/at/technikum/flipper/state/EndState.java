package at.technikum.flipper.state;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.command.GuessNumberCommand;
import at.technikum.flipper.command.GuessNumberForCreditCommand;
import at.technikum.flipper.command.GuessNumberForPointsCommand;
import at.technikum.flipper.util.Util;

import java.util.Scanner;

import static at.technikum.flipper.util.InputUtil.askForYesNo;

public class EndState extends State {
	
	public EndState(Flipper flipper) {
		super(flipper);
		flipper.showGameOver();
		bonusGame();
	}
	
	
	public void bonusGame() {
		Scanner scanner = new Scanner(System.in);
		flipper.showBonusGame();
		new GuessNumberForCreditCommand(scanner).execute(flipper);
		if (flipper.getCredits() > 0) {
			flipper.transitionToReady();
		} else {
			System.out.println("Kein Kredit vorhanden!");
			var insertCoin = askForYesNo("Willst du eine Münze einwerfen? (Y/N)");
			if (insertCoin) {
				System.out.println("\nDu hast: " + flipper.getCredits() + " Credits! \n");
				flipper.transitionToNoCredit();
				flipper.insertCoin();
			}
			else{
				flipper.endGame();
			}
			
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
