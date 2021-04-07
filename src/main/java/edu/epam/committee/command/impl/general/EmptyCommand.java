package edu.epam.committee.command.impl.general;

import edu.epam.committee.command.Command;
import edu.epam.committee.command.CommandResult;
import edu.epam.committee.command.PagePath;
import edu.epam.committee.controller.request.RequestContext;


public class EmptyCommand implements Command {

    @Override
    public CommandResult execute(RequestContext requestContext) {
        String page = PagePath.ERROR;
        return CommandResult.setForwardPage(page);
    }

}
