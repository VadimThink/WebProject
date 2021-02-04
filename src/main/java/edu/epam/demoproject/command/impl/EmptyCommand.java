package edu.epam.demoproject.command.impl;

import edu.epam.demoproject.command.Command;
import edu.epam.demoproject.command.CommandResult;
import edu.epam.demoproject.constant.PagePath;
import edu.epam.demoproject.controller.request.RequestContext;


public class EmptyCommand implements Command {

    @Override
    public CommandResult execute(RequestContext requestContext) {
        String page = PagePath.LOGIN;
        return CommandResult.redirect(page);
    }

}
