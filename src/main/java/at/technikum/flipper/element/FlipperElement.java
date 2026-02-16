package at.technikum.flipper.element;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.command.*;
import at.technikum.flipper.mediator.ElementMediator;

public abstract class FlipperElement {
	protected String name;
	protected ElementMediator mediator;
	protected Command hitCommand;
	
	public FlipperElement(String name) {
		this(name, null);
	}
	
	public FlipperElement(String name, ElementMediator mediator) {
		this.name = name;
		this.mediator = mediator;
	}
	
	public void setMediator(ElementMediator mediator) {
		this.mediator = mediator;
	}
	
	public ElementMediator getMediator() {
		return this.mediator;
	}
	
	
	public void setHitCommand(Command command) {
		this.hitCommand = command;
	}
	
	public void hit(Flipper flipper) {
		System.out.println(name + " wurde getroffen!");
		if (hitCommand != null) hitCommand.execute(flipper);
		if (mediator != null) mediator.onHit(this);
	}
	
	public String getName() {
		return name;
	}
	

}
