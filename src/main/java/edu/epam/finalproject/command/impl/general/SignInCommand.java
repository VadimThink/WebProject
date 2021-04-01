package edu.epam.finalproject.command.impl.general;

import edu.epam.finalproject.command.*;
import edu.epam.finalproject.controller.request.RequestContext;
import edu.epam.finalproject.entity.RoleType;
import edu.epam.finalproject.logic.service.ServiceException;
import edu.epam.finalproject.logic.service.UserService;
import edu.epam.finalproject.logic.validator.InputValidator;
import edu.epam.finalproject.util.PasswordEncrypt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SignInCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SignInCommand.class);
    private static final UserService userService = new UserService();

    @Override
    public CommandResult execute(RequestContext requestContext) {
        String page;
        String login = requestContext.getParameter(RequestParameter.LOGIN);
        String password = requestContext.getParameter(RequestParameter.PASSWORD);
        try {
            if (InputValidator.validateAuth(login, password)) {
                String encryptedPassword = PasswordEncrypt.encryptPassword(password);
                boolean isUserExist = userService.checkUserByLoginAndPassword(login, encryptedPassword);
                if (isUserExist) {
                    boolean isUserNotBlocked = userService.isUserNotBlocked(login);
                    if (isUserNotBlocked) {
                        boolean isAdmin = false;
                        try {
                            isAdmin = userService.checkAdminRole(login);
                        } catch (ServiceException e) {
                            logger.error(e);
                        }
                        if (isAdmin) {
                            requestContext.addSessionAttribute(SessionAttribute.ROLE, RoleType.ADMIN);
                            page = PagePath.ADMIN_MENU;
                        } else {
                            requestContext.addSessionAttribute(SessionAttribute.ROLE, RoleType.USER);
                            page = PagePath.USER_MENU;
                        }
                        requestContext.addSessionAttribute(SessionAttribute.USER, login);
                    } else {
                        requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, CommandMessage.USER_BLOCKED);
                        page = PagePath.LOGIN;
                    }
                } else {
                    requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, CommandMessage.WRONG_AUTH);
                    page = PagePath.LOGIN;
                }
            } else {
                requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, CommandMessage.VALIDATION_ERROR);
                page = PagePath.LOGIN;
            }
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, page);
            return CommandResult.setForwardPage(page);
        } catch (ServiceException e) {
            logger.error(e);
            requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, CommandMessage.DATABASE_ERROR);
            page = PagePath.LOGIN;
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, page);
            return CommandResult.setForwardPage(page);
        }
    }
}