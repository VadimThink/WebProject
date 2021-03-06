package edu.epam.finalproject.command.impl.general;

import edu.epam.finalproject.command.*;
import edu.epam.finalproject.constant.RoleType;
import edu.epam.finalproject.controller.request.RequestContext;

public class OpenMenuCommand implements Command {

    @Override
    public CommandResult execute(RequestContext requestContext) {
        RoleType role = (RoleType) requestContext.getAttribute(SessionAttribute.ROLE);
        if(role == RoleType.ADMIN){
            return CommandResult.setRedirectPage(PagePath.ADMIN_MENU);
        }else {
            return CommandResult.setRedirectPage(PagePath.USER_MENU);
        }
    }
}
