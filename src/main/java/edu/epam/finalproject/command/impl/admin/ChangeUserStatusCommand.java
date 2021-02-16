package edu.epam.finalproject.command.impl.admin;

import edu.epam.finalproject.command.Command;
import edu.epam.finalproject.command.CommandResult;
import edu.epam.finalproject.command.PagePath;
import edu.epam.finalproject.command.RequestParameter;
import edu.epam.finalproject.constant.SessionAttribute;
import edu.epam.finalproject.constant.StatusType;
import edu.epam.finalproject.controller.request.RequestContext;
import edu.epam.finalproject.service.ServiceException;
import edu.epam.finalproject.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChangeUserStatusCommand implements Command {
    private static final UserService userService = new UserService();
    private static final Logger logger = LogManager.getLogger(ChangeUserStatusCommand.class);

    private final StatusType statusType;

    public ChangeUserStatusCommand(StatusType statusType) {
        this.statusType = statusType;
    }

    @Override
    public CommandResult execute(RequestContext requestContext) {
        String login = requestContext.getParameter(RequestParameter.USER_LOGIN);
        try{
            userService.updateUserStatus(login, statusType);
        }catch (ServiceException e){
            e.printStackTrace();
            logger.error(e);
        }
        String page = PagePath.USERS_LIST;
        requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, page);
        return CommandResult.setRedirectPage(page);
    }
}
