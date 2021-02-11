package edu.epam.demoproject.command.impl;

import edu.epam.demoproject.command.Command;
import edu.epam.demoproject.command.CommandResult;
import edu.epam.demoproject.constant.PagePath;
import edu.epam.demoproject.constant.SessionAttribute;
import edu.epam.demoproject.controller.request.RequestContext;

public class LogoutCommand implements Command {

    @Override
    public CommandResult execute(RequestContext requestContext) {
        requestContext.addSessionAttribute(SessionAttribute.INVALIDATE_ATTRIBUTE, true);

        return CommandResult.setRedirectPage(PagePath.LOGIN);
    }

}
