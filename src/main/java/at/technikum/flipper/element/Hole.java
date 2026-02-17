package at.technikum.flipper.element;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.visitor.FlipperElementVisitor;

public class Hole extends FlipperElement {
    
    private int hitCount = 0;
    public Hole(String name) {
        super(name);
    }
    
    @Override
    public void hit(Flipper flipper) {
        hitCount++;
        System.out.println("Hole " + name + " wird zum " + hitCount + ". getroffen");
        super.hit(flipper);
        
    }
    public void reset() {
        hitCount= 0;
        System.out.println("Reset: " + name);
    }
    
    @Override
    public void accept(FlipperElementVisitor visitor) {
        visitor.visit(this);
    }
}
