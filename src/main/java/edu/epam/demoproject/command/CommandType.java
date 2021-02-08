package edu.epam.demoproject.command;

import edu.epam.demoproject.command.impl.*;

public enum CommandType {

    REGISTER(new SignUpCommand()),
    LOGIN(new SignInCommand()),
    LOGIN_PAGE(new ForwardPageCommand(CommandName.LOGIN_PAGE)),
    ENGLISH(new EnglishLanguageCommand()),
    RUSSIAN(new RussianLanguageCommand());

    private final Command command;

    CommandType(Command command) {
        this.command = command;

    }

    public Command getCommand() {
        return command;
    }

}
