package edu.epam.finalproject.command.impl.general;

import edu.epam.finalproject.command.*;
import edu.epam.finalproject.controller.request.RequestContext;
import edu.epam.finalproject.entity.RoleType;
import edu.epam.finalproject.service.ServiceException;
import edu.epam.finalproject.service.UserService;
import edu.epam.finalproject.util.PasswordEncrypt;
import edu.epam.finalproject.validator.InputValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SignUpCommand implements Command {
    private static final UserService userService = new UserService();
    private static final Logger logger = LogManager.getLogger(SignUpCommand.class);

    @Override
    public CommandResult execute(RequestContext requestContext) {
        String page;
        String login = requestContext.getParameter(RequestParameter.LOGIN);
        String password = requestContext.getParameter(RequestParameter.PASSWORD);
        String repeatPassword = requestContext.getParameter(RequestParameter.REPEAT_PASSWORD);
        if (!password.equals(repeatPassword)) {
            requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, Message.DIFFERENT_PASSWORDS);
            page = PagePath.REGISTRATION;
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, page);
            return CommandResult.setForwardPage(page);
        }
        if (InputValidator.validateAuth(login, password)) {
            String encryptedPassword = PasswordEncrypt.encryptPassword(password);
            boolean isCreated = false;
            try {
                isCreated = userService.createNewUser(login, encryptedPassword);
            } catch (ServiceException e) {
                logger.error(e);
            }
            if (isCreated) {
                requestContext.addSessionAttribute(SessionAttribute.USER, login);
                page = PagePath.USER_MENU;
                requestContext.addSessionAttribute(SessionAttribute.ROLE, RoleType.USER);
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, page);
                return CommandResult.setForwardPage(page);
            } else {
                requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, Message.THIS_USER_IS_EXIST);
                page = PagePath.REGISTRATION;
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, page);
                return CommandResult.setForwardPage(page);
            }
        } else {
            requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, Message.VALIDATION_ERROR);
            page = PagePath.REGISTRATION;
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, page);
            return CommandResult.setForwardPage(page);
        }
    }
}
