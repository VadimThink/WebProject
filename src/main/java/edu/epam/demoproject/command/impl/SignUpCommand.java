package edu.epam.demoproject.command.impl;

import edu.epam.demoproject.command.Command;
import edu.epam.demoproject.command.CommandResult;
import edu.epam.demoproject.constant.Attribute;
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
        if (userService.createNewUser(login, password)) {
            requestContext.addSessionAttribute(Attribute.USER, login);
            page = PagePath.MAIN;
        } else {
            page = PagePath.REGISTRATION;
        }
        return CommandResult.redirect(page);
    }
}
