package edu.epam.finalproject.command.impl;

import edu.epam.finalproject.command.Command;
import edu.epam.finalproject.command.CommandName;
import edu.epam.finalproject.command.CommandResult;
import edu.epam.finalproject.command.PagePath;
import edu.epam.finalproject.constant.SessionAttribute;
import edu.epam.finalproject.controller.request.RequestContext;


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
            default -> throw new IllegalArgumentException("Unknown page: " + commandType);
        }
    }
}
