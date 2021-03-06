package edu.epam.finalproject.command.impl.admin;

import edu.epam.finalproject.command.*;
import edu.epam.finalproject.constant.Message;
import edu.epam.finalproject.command.SessionAttribute;
import edu.epam.finalproject.controller.request.RequestContext;
import edu.epam.finalproject.entity.User;
import edu.epam.finalproject.service.ServiceException;
import edu.epam.finalproject.service.UserService;
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
        long usersNumber = 0;
        long lastId = firstId;
        try {
            usersNumber = userService.findNumberOfUsers();
        } catch (ServiceException e) {
            e.printStackTrace();
            logger.error(e);
        }
        requestContext.addAttribute(RequestAttribute.USERS_NUMBER, usersNumber);
        long offset = usersNumber - firstId;
        if(offset > DEFAULT_NUMBER_OF_USERS) {
            try {
                usersList = userService.findUsersInRange(firstId, DEFAULT_NUMBER_OF_USERS);
            } catch (ServiceException e) {
                e.printStackTrace();
                logger.error(e);
            }
            lastId = usersList.get(usersList.size() - 1).getId();
        }if(offset <= 0){
            requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, Message.CANT_FIND_USERS_IN_THIS_RANGE);
        }else if(offset <= DEFAULT_NUMBER_OF_USERS){
            try {
                usersList = userService.findUsersInRange(firstId, offset);
            } catch (ServiceException e) {
                e.printStackTrace();
                logger.error(e);
            }
            lastId = usersList.get(usersList.size() - 1).getId();
        }
        requestContext.addAttribute(RequestAttribute.FIRST_ID, firstId);
        requestContext.addAttribute(RequestAttribute.LAST_ID, lastId);
        requestContext.addAttribute(RequestAttribute.USERS_LIST, usersList);
        requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.USERS_PAGINATION);
        return CommandResult.setForwardPage(PagePath.USERS);
    }
}
