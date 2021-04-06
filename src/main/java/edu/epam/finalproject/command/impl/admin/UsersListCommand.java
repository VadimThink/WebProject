package edu.epam.finalproject.command.impl.admin;

import edu.epam.finalproject.command.*;
import edu.epam.finalproject.controller.request.RequestContext;
import edu.epam.finalproject.entity.User;
import edu.epam.finalproject.logic.service.ServiceException;
import edu.epam.finalproject.logic.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class UsersListCommand implements Command {
    private static final UserService userService = new UserService();
    private static final Logger logger = LogManager.getLogger(UsersListCommand.class);

    private static final int FIRST_ID = 0;
    private static final int NUMBER = 6;

    @Override
    public CommandResult execute(RequestContext requestContext) {
        List<User> usersList;
        long usersNumber;
        String page;
        try {
            usersNumber = userService.findNumberOfUsers();
            requestContext.addAttribute(RequestAttribute.USERS_NUMBER, usersNumber);
            usersList = userService.findUsersInRange(FIRST_ID, NUMBER);
            long lastId = usersList.get(usersList.size() - 1).getId();
            requestContext.addAttribute(RequestAttribute.FIRST_ID, FIRST_ID);
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
