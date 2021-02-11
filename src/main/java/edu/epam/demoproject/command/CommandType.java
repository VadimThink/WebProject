package edu.epam.demoproject.command;

import edu.epam.demoproject.command.impl.*;

public enum CommandType {

    REGISTER(new SignUpCommand()),
    LOGIN(new SignInCommand()),
    LOGOUT(new LogoutCommand()),
    LOGIN_PAGE(new RedirectPageCommand(CommandName.LOGIN_PAGE)),
    SIGN_UP_PAGE(new RedirectPageCommand(CommandName.SIGN_UP_PAGE)),
    FORM_PAGE(new RedirectPageCommand(CommandName.FORM_PAGE)),
    SEND_FORM(new SendFormCommand()),
    CHANGE_LANGUAGE(new ChangeLocaleCommand());

    private final Command command;

    CommandType(Command command) {
        this.command = command;

    }

    public Command getCommand() {
        return command;
    }

}
