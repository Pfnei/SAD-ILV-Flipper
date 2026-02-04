package at.technikum.flipper.command;

import at.technikum.flipper.Flipper;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements Command {
    List<Command> commands;

    public MacroCommand() {
        this.commands = new ArrayList<>();
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }

    @Override
    public void execute(Flipper flipper) {
        for (Command command : commands) {
            command.execute(flipper);
        }
    }

}
