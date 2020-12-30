package edu.epam.demoproject.servlet;

import edu.epam.demoproject.command.Command;
import edu.epam.demoproject.command.impl.TurnOffLightCommand;
import edu.epam.demoproject.command.impl.TurnOnLightCommand;
import edu.epam.demoproject.dao.UserDao;
import edu.epam.demoproject.dao.impl.UserDaoImpl;
import edu.epam.demoproject.entity.Light;
import edu.epam.demoproject.entity.UserList;
import edu.epam.demoproject.service.InputValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

@WebServlet(name = "authController", urlPatterns = {"/authController", "*.do"})
public class AuthorizationController extends HttpServlet {
    public void init(){

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<hr/>" + request.getMethod() + "<hr/>" + request.getRequestURI());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserList userList = UserList.getInstance();
        UserDao userDao = new UserDaoImpl();
        response.setContentType("text/html");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (userDao.checkUserByLoginAndPassword(userList, login, password)){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/switcher.jsp");
            dispatcher.forward(request, response);
        }
        else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/wrongLoginOrPassword.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void destroy(){

    }
}

