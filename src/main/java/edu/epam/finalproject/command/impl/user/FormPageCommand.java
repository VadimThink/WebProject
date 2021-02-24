package edu.epam.finalproject.command.impl.user;

import edu.epam.finalproject.command.Command;
import edu.epam.finalproject.command.CommandResult;
import edu.epam.finalproject.command.PagePath;
import edu.epam.finalproject.command.RequestAttribute;
import edu.epam.finalproject.constant.SessionAttribute;
import edu.epam.finalproject.controller.request.RequestContext;
import edu.epam.finalproject.entity.Specialty;
import edu.epam.finalproject.service.ServiceException;
import edu.epam.finalproject.service.CommandService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class FormPageCommand implements Command {
    private static final Logger logger = LogManager.getLogger(FormPageCommand.class);
    private static final CommandService commandService = new CommandService();

    @Override
    public CommandResult execute(RequestContext requestContext) {
        List<Specialty> specialtyList = new ArrayList<>();
        try {
            specialtyList = commandService.findSpecialtyList();
        } catch (ServiceException e) {
            e.printStackTrace();
            logger.error(e);
        }
        requestContext.addAttribute(RequestAttribute.SPECIALTY_LIST, specialtyList);
        requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.FORM);
        return CommandResult.setForwardPage(PagePath.FORM);
    }
}
