package edu.epam.committee.command.impl.general;

import edu.epam.committee.command.Command;
import edu.epam.committee.command.CommandMessage;
import edu.epam.committee.command.CommandResult;
import edu.epam.committee.command.PagePath;
import edu.epam.committee.command.RequestAttribute;
import edu.epam.committee.command.RequestParameter;
import edu.epam.committee.command.SessionAttribute;
import edu.epam.committee.controller.request.RequestContext;
import edu.epam.committee.entity.RoleType;
import edu.epam.committee.entity.Specialty;
import edu.epam.committee.entity.SpecialtyList;
import edu.epam.committee.entity.StatusType;
import edu.epam.committee.entity.User;
import edu.epam.committee.logic.service.ServiceException;
import edu.epam.committee.logic.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProfileCommand implements Command {
    private static final Logger logger = LogManager.getLogger(ProfileCommand.class);
    private static final UserService userService = new UserService();
    private static final String DATE_FORMAT = "yyyy-MM-dd";

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
            SimpleDateFormat formatForDate = new SimpleDateFormat(DATE_FORMAT);
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
