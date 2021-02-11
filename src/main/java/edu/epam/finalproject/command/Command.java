package edu.epam.finalproject.command;

import edu.epam.finalproject.controller.request.RequestContext;

public interface Command {
    CommandResult execute(RequestContext requestContext);
}
