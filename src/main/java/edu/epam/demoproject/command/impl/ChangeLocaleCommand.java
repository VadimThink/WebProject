package edu.epam.demoproject.command.impl;

import edu.epam.demoproject.command.Command;
import edu.epam.demoproject.command.CommandResult;
import edu.epam.demoproject.constant.RequestParameter;
import edu.epam.demoproject.constant.SessionAttribute;
import edu.epam.demoproject.controller.request.RequestContext;

public class ChangeLocaleCommand implements Command {
    private static final String RU = "ru";
    private static final String EN = "en";

    @Override
    public CommandResult execute(RequestContext requestContext) {
        String language = requestContext.getParameter(RequestParameter.LANGUAGE);
        String pagePath = (String) requestContext.getSessionAttribute(SessionAttribute.CURRENT_PAGE);
        switch (language) {
            case RU :
                requestContext.addSessionAttribute(RequestParameter.LANGUAGE, RU);
                break;
            case EN :
                requestContext.addSessionAttribute(RequestParameter.LANGUAGE, EN);
                break;
            default:
                requestContext.addSessionAttribute(RequestParameter.LANGUAGE, RU);
        }
        return CommandResult.setRedirectPage(pagePath);
    }
}
