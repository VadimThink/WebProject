package edu.epam.finalproject.command;

import edu.epam.finalproject.command.impl.admin.*;
import edu.epam.finalproject.command.impl.general.*;
import edu.epam.finalproject.command.impl.user.FormPageCommand;
import edu.epam.finalproject.entity.RoleType;
import edu.epam.finalproject.entity.StatusType;

/**
 * The enum Command type.
 */
public enum CommandType {

    /**
     * The Register command.
     */
    REGISTER(new SignUpCommand(), RoleType.EVERYONE),
    /**
     * The Login command.
     */
    LOGIN(new SignInCommand(), RoleType.EVERYONE),
    /**
     * The Logout command.
     */
    LOGOUT(new LogoutCommand(), RoleType.EVERYONE),
    /**
     * The Login page command.
     */
    LOGIN_PAGE(new PageCommand(CommandName.LOGIN_PAGE), RoleType.EVERYONE),
    /**
     * The Sign up page command.
     */
    SIGN_UP_PAGE(new PageCommand(CommandName.SIGN_UP_PAGE), RoleType.EVERYONE),
    /**
     * The Menu command.
     */
    MENU(new OpenMenuCommand(), RoleType.EVERYONE),
    /**
     * The Fic page, command.
     */
    FIC_PAGE(new PageCommand(CommandName.FIC_PAGE), RoleType.EVERYONE),
    /**
     * The Fitc page command.
     */
    FITC_PAGE(new PageCommand(CommandName.FITC_PAGE), RoleType.EVERYONE),
    /**
     * The Fcsn page command.
     */
    FCSN_PAGE(new PageCommand(CommandName.FCSN_PAGE), RoleType.EVERYONE),
    /**
     * The Fre page command.
     */
    FRE_PAGE(new PageCommand(CommandName.FRE_PAGE), RoleType.EVERYONE),
    /**
     * The Fcp page command.
     */
    FCP_PAGE(new PageCommand(CommandName.FCP_PAGE), RoleType.EVERYONE),
    /**
     * The Fee page command.
     */
    FEE_PAGE(new PageCommand(CommandName.FEE_PAGE), RoleType.EVERYONE),
    /**
     * The Form page command.
     */
    FORM_PAGE(new FormPageCommand(), RoleType.USER),
    /**
     * The Home page command.
     */
    HOME_PAGE(new PageCommand(CommandName.HOME_PAGE), RoleType.EVERYONE),
    /**
     * The Send form command.
     */
    SEND_FORM(new SendFormCommand(), RoleType.EVERYONE),
    /**
     * The Users list command.
     */
    USERS_LIST(new UsersListCommand(), RoleType.ADMIN),
    /**
     * The Users pagination command.
     */
    USERS_PAGINATION(new UsersPaginationCommand(), RoleType.ADMIN),
    /**
     * The Block user command.
     */
    BLOCK_USER(new ChangeUserStatusCommand(StatusType.BLOCKED), RoleType.ADMIN),
    /**
     * The Unblock user command.
     */
    UNBLOCK_USER(new ChangeUserStatusCommand(StatusType.INACTIVE), RoleType.ADMIN),
    /**
     * The Activate user command.
     */
    ACTIVATE_USER(new ChangeUserStatusCommand(StatusType.ACTIVE), RoleType.ADMIN),
    /**
     * The Make user admin command.
     */
    MAKE_USER_ADMIN(new ChangeUserRoleCommand(RoleType.ADMIN), RoleType.ADMIN),
    /**
     * The Profile command.
     */
    PROFILE(new ProfileCommand(false), RoleType.EVERYONE),
    /**
     * The Edit profile command.
     */
    EDIT_PROFILE(new ProfileCommand(true), RoleType.EVERYONE),
    /**
     * The Finish campaign command.
     */
    FINISH_CAMPAIGN(new FinishInroductoryCampaignCommand(), RoleType.ADMIN),
    /**
     * The Change language command.
     */
    CHANGE_LANGUAGE(new ChangeLocaleCommand(), RoleType.EVERYONE),
    /**
     * The Enrollee command.
     */
    ENROLLEE(new EnrolleeListCommand(), RoleType.ADMIN);

    private final Command command;
    private final RoleType role;

    CommandType(Command command, RoleType role) {
        this.command = command;
        this.role = role;
    }

    /**
     * Gets command.
     *
     * @return the command
     */
    public Command getCommand() {
        return command;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public RoleType getRole() {
        return role;
    }
}
