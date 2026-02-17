package at.technikum.flipper;

import at.technikum.flipper.element.*;
import at.technikum.flipper.visitor.*;

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
   
    
    
}

