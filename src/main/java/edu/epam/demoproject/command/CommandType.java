package edu.epam.demoproject.command;

import edu.epam.demoproject.command.impl.ForwardPageCommand;
import edu.epam.demoproject.command.impl.SignInCommand;
import edu.epam.demoproject.command.impl.SignUpCommand;

public enum CommandType {

    REGISTER(new SignUpCommand()),
    LOGIN(new SignInCommand()),
    LOGIN_PAGE(new ForwardPageCommand(CommandName.LOGIN_PAGE));

    private final Command command;

    CommandType(Command command) {
        this.command = command;

    }

    public Command getCommand() {
        return command;
    }

}
