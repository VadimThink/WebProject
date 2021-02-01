package edu.epam.demoproject.command.impl;

import edu.epam.demoproject.command.Command;
import edu.epam.demoproject.command.PagePath;
import edu.epam.demoproject.command.RequestParameter;
import edu.epam.demoproject.dao.DaoException;
import edu.epam.demoproject.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class SignUpCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        try {
            if(userService.createNewUser(login, password)){
                request.setAttribute(RequestParameter.USER, login);
                page = PagePath.MAIN;
            } else  {
                page = PagePath.USER_EXIST;
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return page;
    }
}
