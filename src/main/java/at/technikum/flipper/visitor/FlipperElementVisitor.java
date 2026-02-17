package at.technikum.flipper.visitor;

import at.technikum.flipper.element.*;


public interface FlipperElementVisitor {
	void visit(Ramp ramp);
	void visit(Light light);
	void visit(Bumper bumper);
	void visit(Hole hole);
	void visit(Target target);
	
}