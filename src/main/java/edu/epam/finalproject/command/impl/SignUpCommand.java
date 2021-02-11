package edu.epam.finalproject.command.impl;

import edu.epam.finalproject.command.Command;
import edu.epam.finalproject.command.CommandResult;
import edu.epam.finalproject.constant.*;
import edu.epam.finalproject.controller.request.RequestContext;
import edu.epam.finalproject.service.UserService;

public class SignUpCommand implements Command {
    private static final UserService userService = new UserService();

    @Override
    public CommandResult execute(RequestContext requestContext) {
        String page;
        String login = requestContext.getParameter(RequestParameter.LOGIN);
        String password = requestContext.getParameter(RequestParameter.PASSWORD);
        String repeatPassword = requestContext.getParameter(RequestParameter.REPEAT_PASSWORD);
        if (!password.equals(repeatPassword)) {
            requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, Message.DIFFERENT_PASSWORDS);
            page = PagePath.REGISTRATION;
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, page);
            return CommandResult.setForwardPage(page);
        }
        if (userService.createNewUser(login, password)) {
            requestContext.addSessionAttribute(SessionAttribute.USER, login);
            page = PagePath.USER;
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, page);
            return CommandResult.setRedirectPage(page);
        } else {
            requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, Message.THIS_USER_IS_EXIST);
            page = PagePath.REGISTRATION;
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, page);
            return CommandResult.setForwardPage(page);
        }
    }
}
