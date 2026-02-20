package at.technikum.flipper.element;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.command.Command;
import at.technikum.flipper.mediator.ElementMediator;
import at.technikum.flipper.visitor.FlipperElementVisitor;

public class RampAdapter extends FlipperElement {
	
	private final Ramp ramp;
	
	public RampAdapter(Ramp ramp) {
		super(ramp.getName());
		this.ramp = ramp;
	}
	
	public Ramp getRamp() {
		return ramp;
	}
	
	@Override
	public void setMediator(ElementMediator mediator) {
		ramp.setMediator(mediator);
	}
	
	@Override
	public ElementMediator getMediator() {
		return ramp.getMediator();
	}
	
	@Override
	public void setHitCommand(Command command) {
		ramp.setHitCommand(command);
	}
	
	@Override
	public void hit(Flipper flipper) {
		ramp.crash(flipper);
	}
	
	@Override
	public void accept(FlipperElementVisitor visitor) {
		ramp.accept(visitor);
	}
}