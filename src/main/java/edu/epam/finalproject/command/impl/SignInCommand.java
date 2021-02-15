package edu.epam.finalproject.command.impl;

import edu.epam.finalproject.command.Command;
import edu.epam.finalproject.command.PagePath;
import edu.epam.finalproject.command.RequestAttribute;
import edu.epam.finalproject.constant.*;
import edu.epam.finalproject.controller.request.RequestContext;
import edu.epam.finalproject.service.ServiceException;
import edu.epam.finalproject.service.UserService;
import edu.epam.finalproject.command.CommandResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SignInCommand implements Command {
    private static final UserService userService = new UserService();
    private static final Logger logger = LogManager.getLogger(SignInCommand.class);

    @Override
    public CommandResult execute(RequestContext requestContext) {
        String page;
        String login = requestContext.getParameter(RequestParameter.LOGIN);
        String password = requestContext.getParameter(RequestParameter.PASSWORD);
        boolean isUserExist = false;
        try {
            isUserExist = userService.checkUserByLoginAndPassword(login, password);
        } catch (ServiceException e) {
            e.printStackTrace();
            logger.error(e);
        }
        if (isUserExist) {
            requestContext.addSessionAttribute(SessionAttribute.USER, login);
            boolean isAdmin = false;
            try {
                isAdmin = userService.checkAdminRole(login);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            if (isAdmin) {
                requestContext.addSessionAttribute(SessionAttribute.ROLE, RoleType.ADMIN);
                page = PagePath.ADMIN;
            } else {
                requestContext.addSessionAttribute(SessionAttribute.ROLE, RoleType.USER);
                page = PagePath.USER;
            }
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, page);
            return CommandResult.setRedirectPage(page);
        } else {
            requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, Message.WRONG_AUTH);
            page = PagePath.LOGIN;
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, page);
            return CommandResult.setForwardPage(page);
        }
    }
}
