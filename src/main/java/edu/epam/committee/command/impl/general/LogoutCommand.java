package edu.epam.committee.command.impl.general;

import edu.epam.committee.command.Command;
import edu.epam.committee.command.CommandResult;
import edu.epam.committee.command.PagePath;
import edu.epam.committee.command.SessionAttribute;
import edu.epam.committee.controller.request.RequestContext;

public class LogoutCommand implements Command {

    @Override
    public CommandResult execute(RequestContext requestContext) {
        requestContext.addSessionAttribute(SessionAttribute.INVALIDATE_ATTRIBUTE, true);
        return CommandResult.setForwardPage(PagePath.HOME);
    }

}
