package edu.epam.demoproject.servlet;

import edu.epam.demoproject.dao.DaoException;
import edu.epam.demoproject.service.UserDaoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        UserDaoService userDaoService = new UserDaoService();
        response.setContentType("text/html");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        try {
            if (userDaoService.checkUserByLoginAndPassword(login, password)){
                RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/switcher.jsp");
                dispatcher.forward(request, response);
            } else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/wrongLoginOrPassword.jsp");
                dispatcher.forward(request, response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public void destroy(){

    }
}

