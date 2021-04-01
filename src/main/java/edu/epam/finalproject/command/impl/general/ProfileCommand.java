package edu.epam.finalproject.command.impl.general;

import edu.epam.finalproject.command.*;
import edu.epam.finalproject.controller.request.RequestContext;
import edu.epam.finalproject.entity.*;
import edu.epam.finalproject.logic.service.ServiceException;
import edu.epam.finalproject.logic.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProfileCommand implements Command {
    private static final UserService userService = new UserService();
    private static final Logger logger = LogManager.getLogger(ProfileCommand.class);

    private boolean isEdit;

    public ProfileCommand(boolean isEdit) {
        this.isEdit = isEdit;
    }

    @Override
    public CommandResult execute(RequestContext requestContext) {
        RoleType role = (RoleType) requestContext.getSessionAttribute(SessionAttribute.ROLE);
        User userInfo;
        String login;
        if (role == RoleType.ADMIN) {
            login = requestContext.getParameter(RequestParameter.LOGIN);
            if (login == null) {
                login = (String) requestContext.getSessionAttribute(SessionAttribute.USER);
            }
        } else {
            login = (String) requestContext.getSessionAttribute(SessionAttribute.USER);
        }
        try {
            userInfo = userService.findUserInfo(login);
        } catch (ServiceException e) {
            logger.error(e);
            requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, CommandMessage.DATABASE_ERROR);
            return CommandResult.setForwardPage(PagePath.OPEN_MENU_COMMAND);
        }
        requestContext.addAttribute(RequestAttribute.USER_INFO, userInfo);
        requestContext.addAttribute(RequestAttribute.USER_LOGIN, login);
        if (isEdit && !userInfo.isEnrolled()) {
            try {
                userService.updateUserStatus(login, StatusType.INACTIVE);
            } catch (ServiceException e) {
                logger.error(e);
                requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, CommandMessage.DATABASE_ERROR);
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.PROFILE_COMMAND + login);
                return CommandResult.setForwardPage(PagePath.PROFILE_COMMAND + login);
            }
            Date currentDate = new Date();
            SimpleDateFormat formatForDate = new SimpleDateFormat("yyyy-MM-dd");
            requestContext.addAttribute(RequestAttribute.CURRENT_DATE, formatForDate.format(currentDate));
            List<Specialty> specialtyList = SpecialtyList.getInstance().getSpecialtyList();
            requestContext.addAttribute(RequestAttribute.SPECIALTY_LIST, specialtyList);
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.EDIT_PROFILE + login);
            return CommandResult.setForwardPage(PagePath.FORM);
        } else {
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.PROFILE_COMMAND + login);
            return CommandResult.setForwardPage(PagePath.PROFILE);
        }
    }
}
