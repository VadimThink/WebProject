package edu.epam.finalproject.command.impl.general;

import edu.epam.finalproject.command.Command;
import edu.epam.finalproject.command.CommandResult;
import edu.epam.finalproject.command.PagePath;
import edu.epam.finalproject.constant.SessionAttribute;
import edu.epam.finalproject.controller.request.RequestContext;

public class LogoutCommand implements Command {

    @Override
    public CommandResult execute(RequestContext requestContext) {
        requestContext.addSessionAttribute(SessionAttribute.INVALIDATE_ATTRIBUTE, true);

        return CommandResult.setRedirectPage(PagePath.HOME);
    }

}
