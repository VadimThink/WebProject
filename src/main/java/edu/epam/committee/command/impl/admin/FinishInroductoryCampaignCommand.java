package edu.epam.committee.command.impl.admin;

import edu.epam.committee.command.*;
import edu.epam.committee.controller.request.RequestContext;
import edu.epam.committee.logic.service.ServiceException;
import edu.epam.committee.logic.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FinishInroductoryCampaignCommand implements Command {
    private static final UserService userService = new UserService();
    private static final Logger logger = LogManager.getLogger(FinishInroductoryCampaignCommand.class);


    @Override
    public CommandResult execute(RequestContext requestContext) {
        String page;
        try {
            userService.enrollUsersByCompetition();
            page = (String) requestContext.getSessionAttribute(SessionAttribute.CURRENT_PAGE);
        } catch (ServiceException e) {
            logger.error(e);
            requestContext.addAttribute(RequestAttribute.ERROR_MESSAGE, CommandMessage.DATABASE_ERROR);
            requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.OPEN_MENU_COMMAND);
            page = PagePath.OPEN_MENU_COMMAND;
        }
        return CommandResult.setForwardPage(page);
    }
}
