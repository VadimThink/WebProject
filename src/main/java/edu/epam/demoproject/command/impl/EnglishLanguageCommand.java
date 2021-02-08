package edu.epam.demoproject.command.impl;

import edu.epam.demoproject.command.Command;
import edu.epam.demoproject.command.CommandResult;
import edu.epam.demoproject.constant.Attribute;
import edu.epam.demoproject.controller.request.RequestContext;

public class EnglishLanguageCommand implements Command {

    @Override
    public CommandResult execute(RequestContext requestContext) {
        requestContext.addSessionAttribute(Attribute.LANGUAGE, "en_US");
        String page = requestContext.getHeader();
        return CommandResult.setForwardPage(page);
    }
}
