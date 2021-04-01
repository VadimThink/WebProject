package edu.epam.finalproject.controller.filter;

import edu.epam.finalproject.command.RequestParameter;
import edu.epam.finalproject.command.SessionAttribute;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

/**
 * The type Double posting preventing filter.
 * Which prevent double posting by using Tokens.
 */
public class DoublePostingPreventingFilter implements Filter {
    private final static Logger log = LogManager.getLogger(DoublePostingPreventingFilter.class);

    @Override
    public void init(FilterConfig fg) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session;
        if (request.getMethod().equals("GET")) {
            session = request.getSession(true);
            session.setAttribute(SessionAttribute.SERVER_TOKEN, new Random().nextInt(10000));
            chain.doFilter(req, res);
        } else {
            session = request.getSession();
            int serverToken = (Integer) session.getAttribute(SessionAttribute.SERVER_TOKEN);
            if (req.getParameter(RequestParameter.CLIENT_TOKEN) != null &&
                    serverToken == Integer.parseInt(req.getParameter(RequestParameter.CLIENT_TOKEN))) {
                session.setAttribute(SessionAttribute.SERVER_TOKEN, new Random().nextInt(10000));
                chain.doFilter(req, res);
            } else {
                log.info("Tokens: " + serverToken + "-" + req.getParameter(RequestParameter.CLIENT_TOKEN));
                session.setAttribute(SessionAttribute.SERVER_TOKEN, new Random().nextInt(10000));
                HttpServletResponse response = (HttpServletResponse) res;
                //response.sendRedirect(request.getContextPath() + session.getAttribute(SessionAttribute.CURRENT_PAGE));
                String page = (String) session.getAttribute(SessionAttribute.CURRENT_PAGE);
                RequestDispatcher dispatcher = request.getRequestDispatcher(page);
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    public void destroy() {
    }
}
