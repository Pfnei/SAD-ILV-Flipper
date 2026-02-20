package at.technikum.flipper.util;

import java.util.Scanner;

public class InputUtil {
	
	public static int askForInt(String question, int min, int max) {
		Scanner scanner = new Scanner(System.in);
		int value;
		
		while (true) {
			System.out.print(question);
			
			if (scanner.hasNextInt()) {
				value = scanner.nextInt();
				
				if (value >= min && value <= max) {
					return value;
				} else {
					System.out.println("Bitte Zahl im gültigen Bereich eingeben.");
				}
				
			} else {
				System.out.println("Ungültige Eingabe. Bitte eine ganze Zahl eingeben.");
				scanner.next(); // falsche Eingabe verwerfen
			}
		}
	}
	
	public static boolean askForYesNo(String question) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print(question);
			
			String input = scanner.nextLine().trim().toLowerCase();
			
			if (input.equals("j") || input.equals("ja") || input.equals("y") || input.equals("yes")) {
				return true;
			}
			
			if (input.equals("n") || input.equals("nein") || input.equals("no")) {
				return false;
			}
			
			System.out.println("Ungültige Eingabe. Bitte J/Ja/Y/Yes oder N/Nein/No eingeben.");
		}
		
		
	}
	
	public static String askForLeftRight(String question) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print(question);
			
			String input = scanner.nextLine().trim().toLowerCase();
			
			if (input.equals("l") || input.equals("left") || input.equals("links") || input.equals("yes")) {
				return "l";
			}
			
			if (input.equals("r") || input.equals("rechts") || input.equals("right")) {
				return "r";
			}
			
			System.out.println("Ungültige Eingabe. Bitte  L/Links/Left oder  R/Rechts/Right eingeben.");
		}
	}
}
