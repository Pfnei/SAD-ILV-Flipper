package at.technikum.flipper;

import at.technikum.flipper.command.*;
import at.technikum.flipper.element.*;

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
        System.out.println("\n=== FLIPPER GAME START ===\n");
        
        flipper.pressStart(); // NoCredit -> Warnung
        flipper.insertCoin(); // -> Ready
        flipper.insertCoin(); // Credits++
        flipper.pressStart(); // -> Playing
        
        System.out.println("\n--- Spiel läuft! ---\n");
        
        flipper.flipRight();
        flipper.pressStart();
        flipper.flipLeft();
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
        
       // System.out.println("Aktueller Score: " + ScoreBoard.getInstance().getScore());
        
        
        System.out.println("\n--- Random Hits ---\n");
        
        for (int i = 0; i < 5; i++) {
            flipper.hitRandomElement();
        }
        
        System.out.println("\n--- Bälle verlieren ---\n");
        
        flipper.flipLeft();
        flipper.flipLeft();
        flipper.flipLeft();
        
       // flipper.loseBall();
        // flipper.loseBall();
        //flipper.loseBall();
        
        
    }
    
    
}