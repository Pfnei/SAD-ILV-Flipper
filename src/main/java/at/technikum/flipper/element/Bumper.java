package at.technikum.flipper.element;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.command.AddPointsCommand;
import at.technikum.flipper.command.ToggleLightCommand;
import at.technikum.flipper.command.ToggleRandomLightCommand;
import at.technikum.flipper.util.Util;

import java.util.ArrayList;

public class Bumper extends FlipperElement {
    public Bumper(String name) {
        super(name);
    }
    
    public void hit(Flipper flipper) {
        System.out.println("Hit Bumper " + name);
        new AddPointsCommand(100).execute(flipper);
        new ToggleRandomLightCommand();
    }
}