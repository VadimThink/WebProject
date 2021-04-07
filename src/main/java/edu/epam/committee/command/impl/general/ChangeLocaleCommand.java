package edu.epam.committee.command.impl.general;

import edu.epam.committee.command.Command;
import edu.epam.committee.command.CommandResult;
import edu.epam.committee.command.RequestParameter;
import edu.epam.committee.command.SessionAttribute;
import edu.epam.committee.controller.request.RequestContext;

public class ChangeLocaleCommand implements Command {
    private static final String RU = "ru";
    private static final String EN = "en";

    @Override
    public CommandResult execute(RequestContext requestContext) {
        String language = requestContext.getParameter(RequestParameter.LANGUAGE);
        String pagePath = (String) requestContext.getSessionAttribute(SessionAttribute.CURRENT_PAGE);
        switch (language) {
            case RU:
                requestContext.addSessionAttribute(RequestParameter.LANGUAGE, RU);
                break;
            case EN:
                requestContext.addSessionAttribute(RequestParameter.LANGUAGE, EN);
                break;
            default:
                requestContext.addSessionAttribute(RequestParameter.LANGUAGE, RU);
        }
        return CommandResult.setForwardPage(pagePath);
    }
}
