package edu.epam.finalproject.command.impl.general;

import edu.epam.finalproject.command.Command;
import edu.epam.finalproject.command.CommandName;
import edu.epam.finalproject.command.CommandResult;
import edu.epam.finalproject.command.PagePath;
import edu.epam.finalproject.command.SessionAttribute;
import edu.epam.finalproject.controller.request.RequestContext;


public class RedirectPageCommand implements Command {

    private final String commandType;

    public RedirectPageCommand(String commandType) {
        this.commandType = commandType;
    }

    @Override
    public CommandResult execute(RequestContext requestContext) {
        if (commandType == null) {
            throw new IllegalArgumentException("Invalid page.");
        }
        switch (commandType) {
            case CommandName.LOGIN_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.LOGIN);
                return CommandResult.setRedirectPage(PagePath.LOGIN);
            }
            case CommandName.SIGN_UP_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.REGISTRATION);
                return CommandResult.setRedirectPage(PagePath.REGISTRATION);
            }
            case CommandName.FIC_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.FIC);
                return CommandResult.setRedirectPage(PagePath.FIC);
            }
            case CommandName.FITC_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.FITC);
                return CommandResult.setRedirectPage(PagePath.FITC);
            }
            case CommandName.FCSN_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.FCSN);
                return CommandResult.setRedirectPage(PagePath.FCSN);
            }
            case CommandName.FCP_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.FCP);
                return CommandResult.setRedirectPage(PagePath.FCP);
            }
            case CommandName.FRE_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.FRE);
                return CommandResult.setRedirectPage(PagePath.FRE);
            }
            case CommandName.FEE_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.FEE);
                return CommandResult.setRedirectPage(PagePath.FEE);
            }
            case CommandName.HOME_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.HOME);
                return CommandResult.setRedirectPage(PagePath.HOME);
            }
            default -> throw new IllegalArgumentException("Unknown page: " + commandType);
        }
    }
}
