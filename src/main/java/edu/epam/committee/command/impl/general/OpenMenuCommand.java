package edu.epam.committee.command.impl.general;

import edu.epam.committee.command.Command;
import edu.epam.committee.command.CommandResult;
import edu.epam.committee.command.PagePath;
import edu.epam.committee.command.SessionAttribute;
import edu.epam.committee.controller.request.RequestContext;
import edu.epam.committee.entity.RoleType;

public class OpenMenuCommand implements Command {


    @Override
    public CommandResult execute(RequestContext requestContext) {
        RoleType role = (RoleType) requestContext.getSessionAttribute(SessionAttribute.ROLE);
        if (role == RoleType.ADMIN) {
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.ADMIN_MENU);
            return CommandResult.setForwardPage(PagePath.ADMIN_MENU);
        } else {
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.USER_MENU);
            return CommandResult.setForwardPage(PagePath.USER_MENU);
        }
    }
}
