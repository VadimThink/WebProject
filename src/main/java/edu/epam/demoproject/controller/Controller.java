package edu.epam.demoproject.controller;

import edu.epam.demoproject.command.Command;
import edu.epam.demoproject.command.CommandProvider;
import edu.epam.demoproject.command.CommandResult;
import edu.epam.demoproject.constant.PagePath;
import edu.epam.demoproject.constant.RequestParameter;
import edu.epam.demoproject.connection.ConnectionPool;
import edu.epam.demoproject.controller.request.RequestContext;
import edu.epam.demoproject.controller.request.RequestContextCreator;
import edu.epam.demoproject.controller.request.RequestFiller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controller", urlPatterns = {"/controller", "*.do"})
public class Controller extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestContextCreator requestContextCreator = new RequestContextCreator();
        CommandResult commandResult;
        Command command = CommandProvider.provideCommand(request.getParameter(RequestParameter.COMMAND));
        RequestContext requestContext = requestContextCreator.create(request);
        RequestFiller requestFiller = new RequestFiller();
        commandResult = command.execute(requestContext);
        String page = commandResult.getPage();
        requestFiller.fillData(request, requestContext);
        if (page == null) {
            page = PagePath.LOGIN;//todo
            response.sendRedirect(request.getContextPath() + page);
        }
        if (commandResult.isRedirect()) {
            response.sendRedirect(request.getContextPath() + page);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }
    }

    public void destroy() {
        ConnectionPool pool = ConnectionPool.getInstance();
        pool.destroyPool();

    }

}
