package edu.epam.demoproject.command.impl;

import edu.epam.demoproject.command.Command;
import edu.epam.demoproject.command.CommandName;
import edu.epam.demoproject.command.CommandResult;
import edu.epam.demoproject.constant.PagePath;
import edu.epam.demoproject.constant.SessionAttribute;
import edu.epam.demoproject.controller.request.RequestContext;


public class RedirectPageCommand implements Command {

    private final String commandType;

    public RedirectPageCommand(String commandType) {
        this.commandType = commandType;
    }

    @Override
    public CommandResult execute(RequestContext requestContext) {
        if (commandType == null) {
            throw new IllegalArgumentException("Invalid page.");
        }
        switch (commandType) {
            case CommandName.LOGIN_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.LOGIN);
                return CommandResult.setRedirectPage(PagePath.LOGIN);
            }
            case CommandName.SIGN_UP_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.REGISTRATION);
                return CommandResult.setRedirectPage(PagePath.REGISTRATION);
            }
            case CommandName.FORM_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.FORM);
                return CommandResult.setRedirectPage(PagePath.FORM);
            }
            default -> throw new IllegalArgumentException("Unknown page: " + commandType);
        }
    }
}
