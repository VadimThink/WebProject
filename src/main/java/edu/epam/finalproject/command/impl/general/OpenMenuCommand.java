package edu.epam.finalproject.command.impl.general;

import edu.epam.finalproject.command.*;
import edu.epam.finalproject.entity.RoleType;
import edu.epam.finalproject.controller.request.RequestContext;

public class OpenMenuCommand implements Command {

    @Override
    public CommandResult execute(RequestContext requestContext) {
        RoleType role = (RoleType) requestContext.getSessionAttribute(SessionAttribute.ROLE);
        if(role == RoleType.ADMIN){
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.ADMIN_MENU);
            return CommandResult.setForwardPage(PagePath.ADMIN_MENU);
        }else {
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE,PagePath.USER_MENU);
            return CommandResult.setForwardPage(PagePath.USER_MENU);
        }
    }
}
