package edu.epam.committee.command;

import edu.epam.committee.command.impl.general.EmptyCommand;
import edu.epam.committee.controller.request.RequestContext;
import edu.epam.committee.entity.RoleType;

public class CommandProvider {
    private CommandProvider() {
    }

    public static Command provideCommand(String command, RequestContext requestContext) {
        Command currentCommand;
        RoleType role = CommandType.valueOf(command.toUpperCase()).getRole();
        if (command.isEmpty()) {
            return new EmptyCommand();
        }
        if (role == requestContext.getSessionAttribute(SessionAttribute.ROLE) || role == RoleType.EVERYONE) {
            try {
                currentCommand = CommandType.valueOf(command.toUpperCase()).getCommand();
            } catch (IllegalArgumentException exp) {
                currentCommand = new EmptyCommand();
            }
        } else {
            currentCommand = new EmptyCommand();
        }
        return currentCommand;
    }
}
