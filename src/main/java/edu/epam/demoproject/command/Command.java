package edu.epam.demoproject.command;

import edu.epam.demoproject.controller.request.RequestContext;

public interface Command {
    CommandResult execute(RequestContext requestContext);
}
