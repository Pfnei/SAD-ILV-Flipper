package at.technikum.flipper.element;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.visitor.FlipperElementVisitor;

public class Target extends FlipperElement {
    private boolean isDown = false;

    public Target(String name) {
        super(name);
    }

    @Override
    public void hit(Flipper flipper) {
        isDown = true;
        System.out.println("Target " + name + " ist umgefallen!");
        super.hit(flipper);
    }
    
    public boolean isDown() {
        return isDown;
    }
    
    public void reset() {
        isDown = false;
        System.out.println("Target " + name + " ist wieder oben!");
        System.out.println("Reset: " + name);
    }
    
    @Override
    public void accept(FlipperElementVisitor visitor) {
        visitor.visit(this);
    }
}