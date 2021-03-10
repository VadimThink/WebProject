package edu.epam.finalproject.command;

import edu.epam.finalproject.command.impl.admin.ChangeUserRoleCommand;
import edu.epam.finalproject.command.impl.admin.ChangeUserStatusCommand;
import edu.epam.finalproject.command.impl.admin.UsersListCommand;
import edu.epam.finalproject.command.impl.admin.UsersPaginationCommand;
import edu.epam.finalproject.command.impl.general.*;
import edu.epam.finalproject.command.impl.user.FormPageCommand;
import edu.epam.finalproject.command.impl.user.SendFormCommand;
import edu.epam.finalproject.entity.RoleType;
import edu.epam.finalproject.entity.StatusType;

public enum CommandType {

    REGISTER(new SignUpCommand(), RoleType.EVERYONE),
    LOGIN(new SignInCommand(), RoleType.EVERYONE),
    LOGOUT(new LogoutCommand(), RoleType.EVERYONE),
    LOGIN_PAGE(new RedirectPageCommand(CommandName.LOGIN_PAGE), RoleType.EVERYONE),
    SIGN_UP_PAGE(new RedirectPageCommand(CommandName.SIGN_UP_PAGE), RoleType.EVERYONE),
    MENU(new OpenMenuCommand(), RoleType.EVERYONE),
    FIC_PAGE(new RedirectPageCommand(CommandName.FIC_PAGE), RoleType.EVERYONE),
    FITC_PAGE(new RedirectPageCommand(CommandName.FITC_PAGE), RoleType.EVERYONE),
    FCSN_PAGE(new RedirectPageCommand(CommandName.FCSN_PAGE), RoleType.EVERYONE),
    FRE_PAGE(new RedirectPageCommand(CommandName.FRE_PAGE), RoleType.EVERYONE),
    FCP_PAGE(new RedirectPageCommand(CommandName.FCP_PAGE), RoleType.EVERYONE),
    FEE_PAGE(new RedirectPageCommand(CommandName.FEE_PAGE), RoleType.EVERYONE),
    FORM_PAGE(new FormPageCommand(), RoleType.USER),
    HOME_PAGE(new RedirectPageCommand(CommandName.HOME_PAGE), RoleType.EVERYONE),
    SEND_FORM(new SendFormCommand(), RoleType.USER),
    USERS_LIST(new UsersListCommand(), RoleType.ADMIN),
    USERS_PAGINATION(new UsersPaginationCommand(), RoleType.ADMIN),
    BLOCK_USER(new ChangeUserStatusCommand(StatusType.BLOCKED), RoleType.ADMIN),
    UNBLOCK_USER(new ChangeUserStatusCommand(StatusType.INACTIVE), RoleType.ADMIN),
    ACTIVATE_USER(new ChangeUserStatusCommand(StatusType.ACTIVE), RoleType.ADMIN),
    MAKE_USER_ADMIN(new ChangeUserRoleCommand(RoleType.ADMIN), RoleType.ADMIN),
    PROFILE(new ProfileCommand(), RoleType.EVERYONE),
    CHANGE_LANGUAGE(new ChangeLocaleCommand(), RoleType.EVERYONE);

    private final Command command;
    private final RoleType role;

    CommandType(Command command, RoleType role) {
        this.command = command;
        this.role = role;
    }

    public Command getCommand() {
        return command;
    }

    public RoleType getRole(){return role;}
}
