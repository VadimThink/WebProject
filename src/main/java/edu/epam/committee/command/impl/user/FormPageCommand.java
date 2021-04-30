package edu.epam.committee.command.impl.user;

import edu.epam.committee.command.Command;
import edu.epam.committee.command.CommandResult;
import edu.epam.committee.command.PagePath;
import edu.epam.committee.command.RequestAttribute;
import edu.epam.committee.command.SessionAttribute;
import edu.epam.committee.controller.request.RequestContext;
import edu.epam.committee.entity.Specialty;
import edu.epam.committee.entity.SpecialtyList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FormPageCommand implements Command {
    private static final Logger logger = LogManager.getLogger(FormPageCommand.class);
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @Override
    public CommandResult execute(RequestContext requestContext) {
        Date currentDate = new Date();
        SimpleDateFormat formatForDate = new SimpleDateFormat(DATE_FORMAT);
        requestContext.addAttribute(RequestAttribute.CURRENT_DATE, formatForDate.format(currentDate));
        List<Specialty> specialtyList = SpecialtyList.getInstance().getSpecialtyList();
        requestContext.addAttribute(RequestAttribute.SPECIALTY_LIST, specialtyList);
        String login = (String) requestContext.getAttribute(SessionAttribute.USER);
        requestContext.addAttribute(RequestAttribute.USER_LOGIN, login);
        requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.FORM_COMMAND + login);
        return CommandResult.setForwardPage(PagePath.FORM);
    }
}
