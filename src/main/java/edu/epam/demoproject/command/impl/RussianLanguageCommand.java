package edu.epam.demoproject.command.impl;

import edu.epam.demoproject.command.Command;
import edu.epam.demoproject.command.CommandResult;
import edu.epam.demoproject.constant.Attribute;
import edu.epam.demoproject.controller.request.RequestContext;

public class RussianLanguageCommand implements Command {

    @Override
    public CommandResult execute(RequestContext requestContext) {
        requestContext.addSessionAttribute(Attribute.LANGUAGE, "ru_Ru");
        String page = requestContext.getHeader();
        return CommandResult.setForwardPage(page);
    }

}
