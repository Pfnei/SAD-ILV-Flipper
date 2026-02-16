package at.technikum.flipper.mediator;

import at.technikum.flipper.element.FlipperElement;
import at.technikum.flipper.element.Ramp;
import at.technikum.flipper.element.Target;

public class TargetGroupRampMediator implements ElementMediator {
	
	private final Ramp ramp;
	private final Target t1;
	private final Target t2;
	
	public TargetGroupRampMediator(Ramp ramp, Target t1, Target t2) {
		this.ramp = ramp;
		this.t1 = t1;
		this.t2 = t2;
	}
	
	@Override
	public void onHit(FlipperElement element) {
		if (!(element instanceof Target)) return;
		
		if (t1.isDown() && t2.isDown()) {
			if (ramp != null) ramp.openRamp();
			t1.reset();
			t2.reset();
		}
	}
}