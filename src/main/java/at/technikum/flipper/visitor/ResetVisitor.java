package at.technikum.flipper.visitor;

import at.technikum.flipper.element.*;


public class ResetVisitor implements FlipperElementVisitor {
	
	@Override
	public void visit(Ramp ramp) {
		ramp.reset();
	}
	
	@Override
	public void visit(Light light) {
		light.reset();
	}
	
	@Override
	public void visit(Bumper bumper) {
		bumper.reset();
	}
	
	@Override
	public void visit(Hole hole) {
		hole.reset();
	}
	
	@Override
	public void visit(Target target) {
		target.reset();
	}
	
	
}