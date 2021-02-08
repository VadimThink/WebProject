package edu.epam.demoproject.command.impl;

import edu.epam.demoproject.command.*;
import edu.epam.demoproject.constant.*;
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
            if (userService.checkAdminRole(login)){
                requestContext.addSessionAttribute(Attribute.ROLE, RoleType.ADMIN);
                page = PagePath.ADMIN;
            }else{
                requestContext.addSessionAttribute(Attribute.ROLE, RoleType.USER);
                page = PagePath.USER;
            }
            return CommandResult.setRedirectPage(page);
        } else {
            requestContext.addAttribute(Attribute.ERROR_MESSAGE, Message.WRONG_AUTH);
            page = LOGIN_PAGE_COMMAND;
            return CommandResult.setForwardPage(page);
        }
    }
}
