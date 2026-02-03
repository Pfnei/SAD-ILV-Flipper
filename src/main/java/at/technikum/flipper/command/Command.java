package at.technikum.flipper.command;

import at.technikum.flipper.Flipper;

public interface Command {
	void execute(Flipper flipper);
}