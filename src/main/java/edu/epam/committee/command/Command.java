package edu.epam.committee.command;

import edu.epam.committee.controller.request.RequestContext;

public interface Command {
    CommandResult execute(RequestContext requestContext);
}
