package edu.epam.finalproject.command.impl.admin;

import edu.epam.finalproject.command.Command;
import edu.epam.finalproject.command.CommandResult;
import edu.epam.finalproject.command.PagePath;
import edu.epam.finalproject.command.RequestParameter;
import edu.epam.finalproject.constant.RoleType;
import edu.epam.finalproject.command.SessionAttribute;
import edu.epam.finalproject.controller.request.RequestContext;
import edu.epam.finalproject.service.ServiceException;
import edu.epam.finalproject.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChangeUserRoleCommand implements Command {
    private static final UserService userService = new UserService();
    private static final Logger logger = LogManager.getLogger(ChangeUserStatusCommand.class);

    private final RoleType role;

    public ChangeUserRoleCommand(RoleType role) {
        this.role = role;
    }

    @Override
    public CommandResult execute(RequestContext requestContext) {
        String login = requestContext.getParameter(RequestParameter.USER_LOGIN);
        try{
            userService.updateUserRole(login, role);
        }catch (ServiceException e){
            logger.error(e);
        }
        String page = PagePath.USERS_LIST;
        requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, page);
        return CommandResult.setRedirectPage(page);
    }
}
