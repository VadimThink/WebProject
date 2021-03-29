package edu.epam.finalproject.command.impl.user;

import edu.epam.finalproject.command.*;
import edu.epam.finalproject.controller.request.RequestContext;
import edu.epam.finalproject.entity.Specialty;
import edu.epam.finalproject.entity.SpecialtyList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FormPageCommand implements Command {
    private static final Logger logger = LogManager.getLogger(FormPageCommand.class);

    @Override
    public CommandResult execute(RequestContext requestContext) {
        Date currentDate = new Date();
        SimpleDateFormat formatForDate = new SimpleDateFormat("yyyy-MM-dd");
        requestContext.addAttribute(RequestAttribute.CURRENT_DATE, formatForDate.format(currentDate));
        List<Specialty> specialtyList = SpecialtyList.getInstance().getSpecialtyList();
        requestContext.addAttribute(RequestAttribute.SPECIALTY_LIST, specialtyList);
        String login = (String) requestContext.getAttribute(SessionAttribute.USER);
        requestContext.addAttribute(RequestAttribute.USER_LOGIN, login);
        requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.FORM_COMMAND + login);
        return CommandResult.setForwardPage(PagePath.FORM);
    }
}
