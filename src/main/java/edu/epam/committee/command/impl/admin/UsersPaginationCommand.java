package edu.epam.committee.command.impl.admin;

import edu.epam.committee.command.*;
import edu.epam.committee.controller.request.RequestContext;
import edu.epam.committee.entity.User;
import edu.epam.committee.logic.service.ServiceException;
import edu.epam.committee.logic.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class UsersPaginationCommand implements Command {

    private static final UserService userService = new UserService();
    private static final Logger logger = LogManager.getLogger(UsersListCommand.class);

    private static final int DEFAULT_NUMBER_OF_USERS = 6;

    @Override
    public CommandResult execute(RequestContext requestContext) {
        long firstId = Long.parseLong(requestContext.getParameter(RequestParameter.LAST_ID));
        List<User> usersList = new ArrayList<>();
        long usersNumber;
        long lastId = firstId;
        String page;
        try {
            usersNumber = userService.findNumberOfUsers();
            requestContext.addAttribute(RequestAttribute.USERS_NUMBER, usersNumber);
            long offset = usersNumber - firstId;
            if (offset > DEFAULT_NUMBER_OF_USERS) {
                usersList = userService.findUsersInRange(firstId, DEFAULT_NUMBER_OF_USERS);
                lastId = usersList.get(usersList.size() - 1).getId();
            }
            if (offset <= 0) {
                requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, CommandMessage.CANT_FIND_USERS_IN_THIS_RANGE);
            } else if (offset <= DEFAULT_NUMBER_OF_USERS) {
                usersList = userService.findUsersInRange(firstId, offset);
                lastId = usersList.get(usersList.size() - 1).getId();
            }
            requestContext.addAttribute(RequestAttribute.FIRST_ID, firstId);
            requestContext.addAttribute(RequestAttribute.LAST_ID, lastId);
            requestContext.addAttribute(RequestAttribute.USERS_LIST, usersList);
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.USERS_LIST);
            page = PagePath.USERS;
        } catch (ServiceException e) {
            logger.error(e);
            requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, CommandMessage.DATABASE_ERROR);
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.USERS_LIST);
            page = PagePath.USERS_LIST;
        }
        return CommandResult.setForwardPage(page);
    }
}
