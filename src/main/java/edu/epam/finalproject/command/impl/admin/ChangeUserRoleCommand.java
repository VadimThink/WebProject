package edu.epam.finalproject.command.impl.admin;

import edu.epam.finalproject.command.*;
import edu.epam.finalproject.controller.request.RequestContext;
import edu.epam.finalproject.entity.RoleType;
import edu.epam.finalproject.logic.service.ServiceException;
import edu.epam.finalproject.logic.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Change user role command.
 */
public class ChangeUserRoleCommand implements Command {
    private static final UserService userService = new UserService();
    private static final Logger logger = LogManager.getLogger(ChangeUserStatusCommand.class);

    private final RoleType role;

    public ChangeUserRoleCommand(RoleType role) {
        this.role = role;
    }

    @Override
    public CommandResult execute(RequestContext requestContext) {
        String page;
        String login = requestContext.getParameter(RequestParameter.USER_LOGIN);
        try {
            userService.updateUserRole(login, role);
        } catch (ServiceException e) {
            logger.error(e);
            requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, CommandMessage.DATABASE_ERROR);
            page = (String) requestContext.getSessionAttribute(SessionAttribute.CURRENT_PAGE);
            return CommandResult.setForwardPage(page);
        }
        page = (String) requestContext.getSessionAttribute(SessionAttribute.CURRENT_PAGE);
        return CommandResult.setForwardPage(page);
    }
}
