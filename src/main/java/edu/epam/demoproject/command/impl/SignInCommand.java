package edu.epam.demoproject.command.impl;

import edu.epam.demoproject.command.*;
import edu.epam.demoproject.constant.Attribute;
import edu.epam.demoproject.constant.Message;
import edu.epam.demoproject.constant.PagePath;
import edu.epam.demoproject.constant.RequestParameter;
import edu.epam.demoproject.controller.request.RequestContext;
import edu.epam.demoproject.service.UserService;


public class SignInCommand implements Command {
    private static final String LOGIN_PAGE_COMMAND = "controller?command=" + CommandName.LOGIN_PAGE;
    private static final UserService userService = new UserService();

    @Override
    public CommandResult execute(RequestContext requestContext) {
        String page;
        String login = requestContext.getParameter(RequestParameter.LOGIN);
        String password = requestContext.getParameter(RequestParameter.PASSWORD);
        if (userService.checkUserByLoginAndPassword(login, password)) {
            requestContext.addSessionAttribute(Attribute.USER, login);
            page = PagePath.MAIN;
            return CommandResult.redirect(page);
        } else {
            requestContext.addAttribute(Attribute.ERROR_MESSAGE, Message.WRONG_AUTH);
            page = LOGIN_PAGE_COMMAND;
            return CommandResult.forward(page);
        }
    }
}
