package edu.epam.finalproject.controller;

import edu.epam.finalproject.command.*;
import edu.epam.finalproject.connection.ConnectionPool;
import edu.epam.finalproject.controller.request.RequestContext;
import edu.epam.finalproject.controller.request.RequestContextCreator;
import edu.epam.finalproject.controller.request.RequestFiller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//валидаторы
@WebServlet(name = "controller", urlPatterns = {"/controller", "*.do"})
public class Controller extends HttpServlet {
    private static final RequestContextCreator requestContextCreator = new RequestContextCreator();
    private static final RequestFiller requestFiller = new RequestFiller();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        CommandResult commandResult;
        RequestContext requestContext = requestContextCreator.create(request);
        String requestParameter = request.getParameter(RequestParameter.COMMAND);
        Command command = CommandProvider.provideCommand(requestParameter, requestContext);
        commandResult = command.execute(requestContext);
        String page = commandResult.getPage();
        requestFiller.fillData(request, requestContext);
        if (page == null) {
            page = PagePath.ERROR_404;
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
