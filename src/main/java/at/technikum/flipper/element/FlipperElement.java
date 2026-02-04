package at.technikum.flipper.element;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.command.*;

public abstract class FlipperElement {
	protected String name;
	protected Command hitCommand;
	
	public FlipperElement(String name) {
		this.name = name;
	}
	
	public void setHitCommand(Command command) {
		this.hitCommand = command;
	}
	
	public void hit(Flipper flipper) {
		System.out.println(name + " wurde getroffen!");
		if (hitCommand != null) {
			hitCommand.execute(flipper);
		}
	}
	
	public String getName() {
		if (name != null) {
			return name;
		}
		return null;
	}
}
