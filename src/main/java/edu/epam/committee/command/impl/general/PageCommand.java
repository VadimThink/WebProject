package edu.epam.committee.command.impl.general;

import edu.epam.committee.command.Command;
import edu.epam.committee.command.CommandName;
import edu.epam.committee.command.CommandResult;
import edu.epam.committee.command.PagePath;
import edu.epam.committee.command.SessionAttribute;
import edu.epam.committee.controller.request.RequestContext;

public class PageCommand implements Command {

    private final String commandType;

    public PageCommand(String commandType) {
        this.commandType = commandType;
    }

    @Override
    public CommandResult execute(RequestContext requestContext) {
        if (commandType == null) {
            throw new IllegalArgumentException("Invalid page.");
        }
        String page;
        switch (commandType) {
            case CommandName.LOGIN_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.LOGIN);
                page = PagePath.LOGIN;
            }
            case CommandName.SIGN_UP_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.REGISTRATION);
                page = PagePath.REGISTRATION;
            }
            case CommandName.FIC_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.FIC);
                page = PagePath.FIC;
            }
            case CommandName.FITC_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.FITC);
                page = PagePath.FITC;
            }
            case CommandName.FCSN_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.FCSN);
                page = PagePath.FCSN;
            }
            case CommandName.FCP_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.FCP);
                page = PagePath.FCP;
            }
            case CommandName.FRE_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.FRE);
                page = PagePath.FRE;
            }
            case CommandName.FEE_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.FEE);
                page = PagePath.FEE;
            }
            case CommandName.HOME_PAGE -> {
                requestContext.addSessionAttribute(SessionAttribute.CURRENT_PAGE, PagePath.HOME);
                page = PagePath.HOME;
            }
            default -> throw new IllegalArgumentException("Unknown page: " + commandType);
        }
        return CommandResult.setForwardPage(page);
    }
}
