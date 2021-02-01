package edu.epam.demoproject.servlet;

import edu.epam.demoproject.command.Command;
import edu.epam.demoproject.command.CommandProvider;
import edu.epam.demoproject.command.PagePath;
import edu.epam.demoproject.connection.ConnectionPool;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controller", urlPatterns = {"/controller", "*.do"})
public class Controller extends HttpServlet {
    private final static String REQUEST_PARAMETER_COMMAND = "command";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        Command command = CommandProvider.provideCommand(request.getParameter(REQUEST_PARAMETER_COMMAND));
        String page = command.execute(request);
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            page = PagePath.LOGIN;
            response.sendRedirect(request.getContextPath() + page);
        }
    }

    public void destroy(){
        ConnectionPool pool = ConnectionPool.getInstance();
        pool.destroyPool();

    }

}
