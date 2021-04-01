package edu.epam.finalproject.command.impl.admin;

import edu.epam.finalproject.command.*;
import edu.epam.finalproject.controller.request.RequestContext;
import edu.epam.finalproject.logic.service.ServiceException;
import edu.epam.finalproject.logic.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FinishInroductoryCampaignCommand implements Command {
    private static final UserService userService = new UserService();
    private static final Logger logger = LogManager.getLogger(FinishInroductoryCampaignCommand.class);


    @Override
    public CommandResult execute(RequestContext requestContext) {
        try {
            userService.enrollUsersByCompetition();
        } catch (ServiceException e) {
        logger.error(e);
        requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, CommandMessage.DATABASE_ERROR);
        requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.OPEN_MENU_COMMAND);
        return CommandResult.setForwardPage(PagePath.OPEN_MENU_COMMAND);
    }
        String page = (String) requestContext.getSessionAttribute(SessionAttribute.CURRENT_PAGE);
        return CommandResult.setForwardPage(page);
    }
}
