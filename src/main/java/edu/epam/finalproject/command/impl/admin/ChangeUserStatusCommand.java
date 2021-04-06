package edu.epam.finalproject.command.impl.admin;

import edu.epam.finalproject.command.*;
import edu.epam.finalproject.controller.request.RequestContext;
import edu.epam.finalproject.entity.StatusType;
import edu.epam.finalproject.logic.service.ServiceException;
import edu.epam.finalproject.logic.service.UserService;
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
        String page;
        try {
            userService.updateUserStatus(login, statusType);
            page = (String) requestContext.getSessionAttribute(SessionAttribute.CURRENT_PAGE);
        } catch (ServiceException e) {
            logger.error(e);
            requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, CommandMessage.DATABASE_ERROR);
            page = (String) requestContext.getSessionAttribute(SessionAttribute.CURRENT_PAGE);
        }
        return CommandResult.setForwardPage(page);
    }
}
