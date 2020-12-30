package edu.epam.demoproject.servlet;

import edu.epam.demoproject.dao.DaoException;
import edu.epam.demoproject.dao.UserDao;
import edu.epam.demoproject.dao.impl.UserDaoImpl;
import edu.epam.demoproject.entity.User;
import edu.epam.demoproject.entity.UserList;
import edu.epam.demoproject.util.IdGenerator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "regController", urlPatterns = {"/regController"})
public class RegistrationController extends HttpServlet {
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<hr/>" + request.getMethod() + "<hr/>" + request.getRequestURI());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        IdGenerator idGenerator = IdGenerator.getInstance();
        UserList userList = UserList.getInstance();
        UserDao userDao = new UserDaoImpl();
        response.setContentType("text/html");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        try {
            User newUser = new User(idGenerator.getId(), login, password);
            userDao.addUserToList(newUser, userList);
        } catch (DaoException e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/thisUserIsExist.jsp");
            dispatcher.forward(request, response);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/switcher.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {

    }
}
