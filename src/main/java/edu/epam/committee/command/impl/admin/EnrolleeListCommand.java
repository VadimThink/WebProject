package edu.epam.committee.command.impl.admin;

import edu.epam.committee.command.Command;
import edu.epam.committee.command.CommandMessage;
import edu.epam.committee.command.CommandResult;
import edu.epam.committee.command.PagePath;
import edu.epam.committee.command.RequestAttribute;
import edu.epam.committee.command.RequestParameter;
import edu.epam.committee.command.SessionAttribute;
import edu.epam.committee.controller.request.RequestContext;
import edu.epam.committee.entity.Specialty;
import edu.epam.committee.entity.SpecialtyList;
import edu.epam.committee.entity.User;
import edu.epam.committee.logic.service.ServiceException;
import edu.epam.committee.logic.service.UserService;
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
