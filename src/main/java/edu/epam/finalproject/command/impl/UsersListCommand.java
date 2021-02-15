package edu.epam.finalproject.command.impl;

import edu.epam.finalproject.command.Command;
import edu.epam.finalproject.command.CommandResult;
import edu.epam.finalproject.command.PagePath;
import edu.epam.finalproject.command.RequestAttribute;
import edu.epam.finalproject.constant.SessionAttribute;
import edu.epam.finalproject.controller.request.RequestContext;
import edu.epam.finalproject.entity.User;
import edu.epam.finalproject.service.ServiceException;
import edu.epam.finalproject.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class UsersListCommand implements Command {
    private static final UserService userService = new UserService();
    private static final Logger logger = LogManager.getLogger(UsersListCommand.class);

    @Override
    public CommandResult execute(RequestContext requestContext) {
        List<User> usersList = new ArrayList<>();
        try {
            usersList = userService.findAllUsers();
        } catch (ServiceException e) {
            e.printStackTrace();
            logger.error(e);
        }
        requestContext.addAttribute(RequestAttribute.USERS_LIST, usersList);
        requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.USERS_LIST);
        return CommandResult.setForwardPage(PagePath.USERS_LIST);
    }
}
