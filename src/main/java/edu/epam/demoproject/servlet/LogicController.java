package edu.epam.demoproject.servlet;

import edu.epam.demoproject.command.Command;
import edu.epam.demoproject.command.impl.TurnOffLightCommand;
import edu.epam.demoproject.command.impl.TurnOnLightCommand;
import edu.epam.demoproject.entity.Light;
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

@WebServlet(name = "logicController", urlPatterns = {"/logicController"})
public class LogicController extends HttpServlet {
    public void init(){

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<hr/>" + request.getMethod() + "<hr/>" + request.getRequestURI());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        InputValidator validator = new InputValidator();
        Light light = new Light();
        String picPath;
        response.setContentType("text/html");
        String lightCondition = request.getParameter("lightCondition");
        if(validator.checkStringLightCondition(lightCondition)) {
            if (lightCondition.equals("включен")) {
                Command turnOnLightCommand = new TurnOnLightCommand(light);
                turnOnLightCommand.execute();
                picPath = "/images/turnedOn.png";
            } else {
                Command turnOffLightCommand = new TurnOffLightCommand(light);
                turnOffLightCommand.execute();
                picPath = "/images/turnedOff.png";
            }
            String result = lightCondition.toUpperCase(Locale.ROOT);
            request.setAttribute("res", result);
            request.setAttribute("picPath", picPath);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/result.jsp");
            dispatcher.forward(request, response);
        }
        else {
            request.setAttribute("res", lightCondition);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/wrongInput.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void destroy(){

    }
}
