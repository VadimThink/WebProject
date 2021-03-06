package edu.epam.finalproject.command;

import edu.epam.finalproject.command.impl.admin.ChangeUserRoleCommand;
import edu.epam.finalproject.command.impl.admin.ChangeUserStatusCommand;
import edu.epam.finalproject.command.impl.admin.UsersListCommand;
import edu.epam.finalproject.command.impl.admin.UsersPaginationCommand;
import edu.epam.finalproject.command.impl.general.*;
import edu.epam.finalproject.command.impl.user.FormPageCommand;
import edu.epam.finalproject.command.impl.user.SendFormCommand;
import edu.epam.finalproject.constant.RoleType;
import edu.epam.finalproject.constant.StatusType;

public enum CommandType {

    REGISTER(new SignUpCommand()),
    LOGIN(new SignInCommand()),
    LOGOUT(new LogoutCommand()),
    LOGIN_PAGE(new RedirectPageCommand(CommandName.LOGIN_PAGE)),
    SIGN_UP_PAGE(new RedirectPageCommand(CommandName.SIGN_UP_PAGE)),
    MENU(new OpenMenuCommand()),
    FIC_PAGE(new RedirectPageCommand(CommandName.FIC_PAGE)),
    FITC_PAGE(new RedirectPageCommand(CommandName.FITC_PAGE)),
    FCSN_PAGE(new RedirectPageCommand(CommandName.FCSN_PAGE)),
    FRE_PAGE(new RedirectPageCommand(CommandName.FRE_PAGE)),
    FCP_PAGE(new RedirectPageCommand(CommandName.FCP_PAGE)),
    FEE_PAGE(new RedirectPageCommand(CommandName.FEE_PAGE)),
    FORM_PAGE(new FormPageCommand()),
    HOME_PAGE(new RedirectPageCommand(CommandName.HOME_PAGE)),
    SEND_FORM(new SendFormCommand()),
    USERS_LIST(new UsersListCommand()),
    USERS_PAGINATION(new UsersPaginationCommand()),
    BLOCK_USER(new ChangeUserStatusCommand(StatusType.BLOCKED)),
    UNBLOCK_USER(new ChangeUserStatusCommand(StatusType.INACTIVE)),
    ACTIVATE_USER(new ChangeUserStatusCommand(StatusType.ACTIVE)),
    MAKE_USER_ADMIN(new ChangeUserRoleCommand(RoleType.ADMIN)),
    PROFILE(new ProfileCommand()),
    CHANGE_LANGUAGE(new ChangeLocaleCommand());

    private final Command command;

    CommandType(Command command) {
        this.command = command;

    }

    public Command getCommand() {
        return command;
    }

}
