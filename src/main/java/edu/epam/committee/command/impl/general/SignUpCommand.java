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
import edu.epam.committee.logic.service.ServiceException;
import edu.epam.committee.logic.service.UserService;
import edu.epam.committee.logic.validator.InputValidator;
import edu.epam.committee.util.PasswordEncrypt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SignUpCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SignUpCommand.class);
    private static final UserService userService = new UserService();

    @Override
    public CommandResult execute(RequestContext requestContext) {
        String page;
        String login = requestContext.getParameter(RequestParameter.LOGIN);
        String password = requestContext.getParameter(RequestParameter.PASSWORD);
        String repeatPassword = requestContext.getParameter(RequestParameter.REPEAT_PASSWORD);
        if (!password.equals(repeatPassword)) {
            requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, CommandMessage.DIFFERENT_PASSWORDS);
            page = PagePath.REGISTRATION;
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, page);
            return CommandResult.setForwardPage(page);
        }
        if (InputValidator.validateAuth(login, password)) {
            String encryptedPassword = PasswordEncrypt.encryptPassword(password);
            boolean isCreated;
            try {
                isCreated = userService.createNewUser(login, encryptedPassword);
            } catch (ServiceException e) {
                logger.error(e);
                requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, CommandMessage.DATABASE_ERROR);
                page = PagePath.REGISTRATION;
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, page);
                return CommandResult.setForwardPage(page);
            }
            if (isCreated) {
                requestContext.addSessionAttribute(SessionAttribute.USER, login);
                page = PagePath.USER_MENU;
                requestContext.addSessionAttribute(SessionAttribute.ROLE, RoleType.USER);
            } else {
                requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, CommandMessage.THIS_USER_IS_EXIST);
                page = PagePath.REGISTRATION;
            }
        } else {
            requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, CommandMessage.VALIDATION_ERROR);
            page = PagePath.REGISTRATION;
        }
        requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, page);
        return CommandResult.setForwardPage(page);
    }
}
