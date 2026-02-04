package at.technikum.flipper;

import at.technikum.flipper.command.*;
import at.technikum.flipper.element.*;

public class FlipperGame {
    
    private final Flipper flipper;
    
    private Target target1;
    private Target target2;
    private Bumper bumper1;
    private Hole mysteryHole;
    
    public FlipperGame() {
        this.flipper = new Flipper();
        setupElements();
    }
    
    private void setupElements() {
        target1 = new Target("Target-Red");
        target1.setHitCommand(new AddPointsCommand(100));
        
        target2 = new Target("Target-Blue");
        target2.setHitCommand(new AddPointsCommand(150));
        
        bumper1 = new Bumper("Bumper-1");
        MacroCommand bumperMacro = new MacroCommand();
        bumperMacro.addCommand(new AddPointsCommand(50));
        bumperMacro.addCommand(new PlaySoundCommand("bumper.wav"));
        bumper1.setHitCommand(bumperMacro);
        
        mysteryHole = new Hole("Mystery Hole");
        MacroCommand holeMacro = new MacroCommand();
        holeMacro.addCommand(new AddPointsCommand(500));
        holeMacro.addCommand(new PlaySoundCommand("mystery.wav"));
        mysteryHole.setHitCommand(holeMacro);
    }
    
    public void play() {
        System.out.println("\n=== FLIPPER GAME START ===\n");
        
        flipper.pressStart(); // NoCredit -> Warnung
        flipper.insertCoin(); // -> Ready
        flipper.insertCoin(); // Credits++
        flipper.pressStart(); // -> Playing
        
        System.out.println("\n--- Spiel läuft! ---\n");
        
        target1.hit(this.flipper);
        bumper1.hit(this.flipper);
        target2.hit(this.flipper);
        mysteryHole.hit(this.flipper);
        
       // System.out.println("Aktueller Score: " + ScoreBoard.getInstance().getScore());
        
        System.out.println("\n--- Bälle verlieren ---\n");
       // flipper.loseBall();
        // flipper.loseBall();
        //flipper.loseBall();
        
        flipper.pressStart(); // EndState
    }
    
    public static void main(String[] args) {
        FlipperGame game = new FlipperGame();
        game.play();
    }
}