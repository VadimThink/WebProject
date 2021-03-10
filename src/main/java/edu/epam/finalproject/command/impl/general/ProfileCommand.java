package edu.epam.finalproject.command.impl.general;

import edu.epam.finalproject.command.*;
import edu.epam.finalproject.command.impl.admin.UsersListCommand;
import edu.epam.finalproject.constant.RoleType;
import edu.epam.finalproject.controller.request.RequestContext;
import edu.epam.finalproject.entity.User;
import edu.epam.finalproject.service.ServiceException;
import edu.epam.finalproject.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProfileCommand implements Command {
    private static final UserService userService = new UserService();
    private static final Logger logger = LogManager.getLogger(ProfileCommand.class);

    @Override
    public CommandResult execute(RequestContext requestContext) {
        RoleType role = (RoleType) requestContext.getSessionAttribute(SessionAttribute.ROLE);
        User userInfo = null;
        String login;
        if (role == RoleType.ADMIN){
            login = requestContext.getParameter(RequestParameter.LOGIN);
            if (login == null){
                login = (String) requestContext.getSessionAttribute(SessionAttribute.USER);
            }
        }else{
            login = (String) requestContext.getSessionAttribute(SessionAttribute.USER);
        }
        try {
            userInfo = userService.findUserInfo(login);
        } catch (ServiceException e) {
            logger.error(e);
        }
        requestContext.addAttribute(RequestAttribute.USER_INFO, userInfo);
        requestContext.addAttribute(RequestAttribute.USER_LOGIN, login);
        requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.PROFILE_COMMAND + login) ;
        return CommandResult.setForwardPage(PagePath.PROFILE);
    }
}
