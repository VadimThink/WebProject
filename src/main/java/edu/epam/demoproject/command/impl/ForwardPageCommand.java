package edu.epam.demoproject.command.impl;

import edu.epam.demoproject.command.Command;
import edu.epam.demoproject.command.CommandName;
import edu.epam.demoproject.command.CommandResult;
import edu.epam.demoproject.constant.PagePath;
import edu.epam.demoproject.controller.request.RequestContext;


public class ForwardPageCommand implements Command {

    private final String commandType;

    public ForwardPageCommand(String commandType) {
        this.commandType = commandType;
    }

    @Override
    public CommandResult execute(RequestContext requestContext) {
        if (commandType == null) {
            throw new IllegalArgumentException("Invalid page.");
        }
        switch (commandType) {
            case CommandName.LOGIN_PAGE:
                return CommandResult.setForwardPage(PagePath.LOGIN);
            default:
                throw new IllegalArgumentException("Unknown page: " + commandType);
        }// TODO: 04.02.2021
    }
}
