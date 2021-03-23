package edu.epam.finalproject.command.impl.general;

import edu.epam.finalproject.command.*;
import edu.epam.finalproject.controller.request.RequestContext;
import edu.epam.finalproject.entity.RoleType;
import edu.epam.finalproject.service.ServiceException;
import edu.epam.finalproject.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SendFormCommand implements Command {
    private static final UserService userService = new UserService();
    private static final Logger logger = LogManager.getLogger(SendFormCommand.class);

    @Override
    public CommandResult execute(RequestContext requestContext) {
        RoleType role = (RoleType) requestContext.getSessionAttribute(SessionAttribute.ROLE);
        String login;
        String page;
        if (role == RoleType.ADMIN){
            login = requestContext.getParameter(RequestParameter.LOGIN);
            if (login == null){
                login = (String) requestContext.getSessionAttribute(SessionAttribute.USER);
            }
        }else{
            login = (String) requestContext.getSessionAttribute(SessionAttribute.USER);
        }
        String firstName = requestContext.getParameter(RequestParameter.FIRST_NAME);
        String secondName = requestContext.getParameter(RequestParameter.SECOND_NAME);
        String thirdName = requestContext.getParameter(RequestParameter.THIRD_NAME);
        String birthday = requestContext.getParameter(RequestParameter.BIRTHDAY);
        String country = requestContext.getParameter(RequestParameter.COUNTRY);
        String locality = requestContext.getParameter(RequestParameter.LOCALITY);
        String address = requestContext.getParameter(RequestParameter.ADDRESS);
        String phone = requestContext.getParameter(RequestParameter.PHONE);
        String email = requestContext.getParameter(RequestParameter.EMAIL);
        int specialty_num = Integer.parseInt(requestContext.getParameter(RequestParameter.SPECIALTY));
        int gpa = Integer.parseInt(requestContext.getParameter(RequestParameter.GPA));
        int languageScore = Integer.parseInt(requestContext.getParameter(RequestParameter.LANGUAGE_SCORE));
        int mathScore = Integer.parseInt(requestContext.getParameter(RequestParameter.MATH_SCORE));
        int thirdScore = Integer.parseInt(requestContext.getParameter(RequestParameter.THIRD_SCORE));
        try {
            userService.updateUserFormData(login, firstName, secondName, thirdName, birthday, country, locality, address,
                    phone, email, specialty_num, gpa, languageScore, mathScore, thirdScore);
        } catch (ServiceException e) {
            logger.error(e);
        }
        page = PagePath.PROFILE_COMMAND + login;
        requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, page);
        return CommandResult.setForwardPage(page);
    }
}
