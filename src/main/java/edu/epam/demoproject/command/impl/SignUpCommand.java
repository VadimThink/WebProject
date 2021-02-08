package edu.epam.demoproject.command.impl;

import edu.epam.demoproject.command.Command;
import edu.epam.demoproject.command.CommandResult;
import edu.epam.demoproject.constant.Attribute;
import edu.epam.demoproject.constant.Message;
import edu.epam.demoproject.constant.PagePath;
import edu.epam.demoproject.constant.RequestParameter;
import edu.epam.demoproject.controller.request.RequestContext;
import edu.epam.demoproject.service.UserService;

public class SignUpCommand implements Command {
    private static final UserService userService = new UserService();

    @Override
    public CommandResult execute(RequestContext requestContext) {
        String page;
        String login = requestContext.getParameter(RequestParameter.LOGIN);
        String password = requestContext.getParameter(RequestParameter.PASSWORD);
        String repeatPassword = requestContext.getParameter(RequestParameter.REPEAT_PASSWORD);
        if (!password.equals(repeatPassword)) {
            requestContext.addAttribute(Attribute.ERROR_MESSAGE, Message.DIFFERENT_PASSWORDS);
            page = PagePath.REGISTRATION;
            return CommandResult.setForwardPage(page);
        }
        if (userService.createNewUser(login, password)) {
            requestContext.addSessionAttribute(Attribute.USER, login);
            page = PagePath.USER;
            return CommandResult.setRedirectPage(page);
        } else {
            requestContext.addAttribute(Attribute.ERROR_MESSAGE, Message.THIS_USER_IS_EXIST);
            page = PagePath.REGISTRATION;
            return CommandResult.setForwardPage(page);
        }
    }
}
