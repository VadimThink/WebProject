package edu.epam.finalproject.command.impl.admin;

import edu.epam.finalproject.command.*;
import edu.epam.finalproject.controller.request.RequestContext;
import edu.epam.finalproject.entity.Specialty;
import edu.epam.finalproject.entity.SpecialtyList;
import edu.epam.finalproject.entity.User;
import edu.epam.finalproject.logic.service.ServiceException;
import edu.epam.finalproject.logic.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class EnrolleeListCommand implements Command {
    private static final UserService userService = new UserService();
    private static final Logger logger = LogManager.getLogger(EnrolleeListCommand.class);

    @Override
    public CommandResult execute(RequestContext requestContext) {
        List<User> usersList;
        List<Specialty> specialtyList = SpecialtyList.getInstance().getSpecialtyList();
        requestContext.addAttribute(RequestAttribute.SPECIALTY_LIST, specialtyList);
        int specialtyNum = Integer.parseInt(requestContext.getParameter(RequestParameter.SPECIALTY));
        try {
            usersList = userService.findAllUsersWithCurrentSpecialty(specialtyNum);
        } catch (ServiceException e) {
            logger.error(e);
            requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, CommandMessage.DATABASE_ERROR);
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.ENROLLEE_COMMAND + specialtyNum);
            return CommandResult.setForwardPage(PagePath.ENROLLEE_COMMAND + specialtyNum);
        }
        requestContext.addAttribute(RequestAttribute.USERS_LIST, usersList);
        requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.ENROLLEE_COMMAND + specialtyNum);
        return CommandResult.setForwardPage(PagePath.ENROLLEE);
    }
}
