package edu.epam.finalproject.command;

import edu.epam.finalproject.command.impl.admin.ChangeUserStatusCommand;
import edu.epam.finalproject.command.impl.admin.UsersListCommand;
import edu.epam.finalproject.command.impl.admin.UsersPaginationCommand;
import edu.epam.finalproject.command.impl.general.*;
import edu.epam.finalproject.command.impl.user.FormPageCommand;
import edu.epam.finalproject.command.impl.user.SendFormCommand;
import edu.epam.finalproject.constant.StatusType;

public enum CommandType {

    REGISTER(new SignUpCommand()),
    LOGIN(new SignInCommand()),
    LOGOUT(new LogoutCommand()),
    LOGIN_PAGE(new RedirectPageCommand(CommandName.LOGIN_PAGE)),
    SIGN_UP_PAGE(new RedirectPageCommand(CommandName.SIGN_UP_PAGE)),
    FORM_PAGE(new FormPageCommand()),
    SEND_FORM(new SendFormCommand()),
    USERS_LIST(new UsersListCommand()),
    USERS_PAGINATION(new UsersPaginationCommand()),
    BLOCK_USER(new ChangeUserStatusCommand(StatusType.BLOCKED)),
    UNBLOCK_USER(new ChangeUserStatusCommand(StatusType.ACTIVE)),
    ACTIVATE_USER(new ChangeUserStatusCommand(StatusType.ACTIVE)),
    CHANGE_LANGUAGE(new ChangeLocaleCommand());

    private final Command command;

    CommandType(Command command) {
        this.command = command;

    }

    public Command getCommand() {
        return command;
    }

}
