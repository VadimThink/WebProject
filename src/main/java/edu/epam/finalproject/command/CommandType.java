package edu.epam.finalproject.command;

import edu.epam.finalproject.command.impl.*;

public enum CommandType {

    REGISTER(new SignUpCommand()),
    LOGIN(new SignInCommand()),
    LOGOUT(new LogoutCommand()),
    LOGIN_PAGE(new RedirectPageCommand(CommandName.LOGIN_PAGE)),
    SIGN_UP_PAGE(new RedirectPageCommand(CommandName.SIGN_UP_PAGE)),
    FORM_PAGE(new FormPageCommand()),
    SEND_FORM(new SendFormCommand()),
    USERS_LIST(new UsersListCommand()),
    CHANGE_LANGUAGE(new ChangeLocaleCommand());

    private final Command command;

    CommandType(Command command) {
        this.command = command;

    }

    public Command getCommand() {
        return command;
    }

}
