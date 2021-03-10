package edu.epam.finalproject.command;

import edu.epam.finalproject.command.impl.general.EmptyCommand;
import edu.epam.finalproject.constant.RoleType;
import edu.epam.finalproject.controller.request.RequestContext;

public class CommandProvider {
    private CommandProvider() {
    }

    public static Command provideCommand(String command, RequestContext requestContext) {
        Command currentCommand;
        RoleType role = CommandType.valueOf(command.toUpperCase()).getRole();

        if (command == null || command.isEmpty()) {
            return new EmptyCommand();
        }
        if (role == requestContext.getSessionAttribute(SessionAttribute.ROLE) || role == RoleType.EVERYONE){
            try {
                currentCommand = CommandType.valueOf(command.toUpperCase()).getCommand();
            } catch (IllegalArgumentException exp) {
                currentCommand = new EmptyCommand();
            }
        }
        else {
            return new EmptyCommand();
        }
        return currentCommand;
    }
}
