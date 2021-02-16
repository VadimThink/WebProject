package edu.epam.finalproject.command.impl.general;

import edu.epam.finalproject.command.Command;
import edu.epam.finalproject.command.CommandResult;
import edu.epam.finalproject.command.PagePath;
import edu.epam.finalproject.controller.request.RequestContext;


public class EmptyCommand implements Command {

    @Override
    public CommandResult execute(RequestContext requestContext) {
        String page = PagePath.ERROR_404;
        return CommandResult.setRedirectPage(page);
    }

}
