package edu.epam.demoproject.command.impl;

import edu.epam.demoproject.command.Command;
import edu.epam.demoproject.command.PagePath;
import edu.epam.demoproject.command.RequestParameter;
import edu.epam.demoproject.dao.DaoException;
import edu.epam.demoproject.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class SignInCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        UserService userService = new UserService();
        String login = request.getParameter(RequestParameter.LOGIN);
        String password = request.getParameter(RequestParameter.PASSWORD);
        try {
            if (userService.checkUserByLoginAndPassword(login, password)){
                request.setAttribute(RequestParameter.USER, login);
                page = PagePath.MAIN;
            } else{
                page = PagePath.WRONG_AUTH;
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return page;
    }
}
