package edu.epam.committee.command.impl.general;

import edu.epam.committee.command.*;
import edu.epam.committee.controller.request.RequestContext;
import edu.epam.committee.entity.RoleType;
import edu.epam.committee.logic.service.ServiceException;
import edu.epam.committee.logic.service.UserService;
import edu.epam.committee.logic.validator.InputValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SendFormCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SendFormCommand.class);
    private static final UserService userService = new UserService();

    @Override
    public CommandResult execute(RequestContext requestContext) {
        RoleType role = (RoleType) requestContext.getSessionAttribute(SessionAttribute.ROLE);
        String login;
        String page;
        if (role == RoleType.ADMIN) {
            login = requestContext.getParameter(RequestParameter.LOGIN);
            if (login == null) {
                login = (String) requestContext.getSessionAttribute(SessionAttribute.USER);
            }
        } else {
            login = (String) requestContext.getSessionAttribute(SessionAttribute.USER);
        }
        String firstName = requestContext.getParameter(RequestParameter.FIRST_NAME);
        String lastName = requestContext.getParameter(RequestParameter.SECOND_NAME);
        String thirdName = requestContext.getParameter(RequestParameter.THIRD_NAME);
        String birthday = requestContext.getParameter(RequestParameter.BIRTHDAY);
        String country = requestContext.getParameter(RequestParameter.COUNTRY);
        String locality = requestContext.getParameter(RequestParameter.LOCALITY);
        String address = requestContext.getParameter(RequestParameter.ADDRESS);
        String phone = requestContext.getParameter(RequestParameter.PHONE);
        String email = requestContext.getParameter(RequestParameter.EMAIL);
        int specialtyNum = Integer.parseInt(requestContext.getParameter(RequestParameter.SPECIALTY));
        int gpa = Integer.parseInt(requestContext.getParameter(RequestParameter.GPA));
        int languageScore = Integer.parseInt(requestContext.getParameter(RequestParameter.LANGUAGE_SCORE));
        int mathScore = Integer.parseInt(requestContext.getParameter(RequestParameter.MATH_SCORE));
        int thirdScore = Integer.parseInt(requestContext.getParameter(RequestParameter.THIRD_SCORE));
        if (InputValidator.validateForm(login, firstName, lastName, thirdName, birthday, country, locality, address,
                phone, email, specialtyNum, gpa, languageScore, mathScore, thirdScore)) {
            try {
                userService.updateUserFormData(login, firstName, lastName, thirdName, birthday, country, locality, address,
                        phone, email, specialtyNum, gpa, languageScore, mathScore, thirdScore);
            } catch (ServiceException e) {
                logger.error(e);
                requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, CommandMessage.DATABASE_ERROR);
                page = PagePath.FORM_COMMAND + login;
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, page);
                return CommandResult.setForwardPage(page);
            }
            page = PagePath.PROFILE_COMMAND + login;
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, page);
        } else {
            page = PagePath.FORM_COMMAND + login;
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, page);
            requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, CommandMessage.VALIDATION_ERROR);
        }
        return CommandResult.setForwardPage(page);
    }
}
