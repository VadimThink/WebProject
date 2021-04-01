package edu.epam.finalproject.controller.listener;

import edu.epam.finalproject.command.PagePath;
import edu.epam.finalproject.command.SessionAttribute;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class UserParameterSessionListener implements HttpSessionListener {
    private static final String EN = "en";
    private static final String SESSION_CREATED = "Session was created";
    public static final Logger logger = LogManager.getLogger(UserParameterSessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        session.setAttribute(SessionAttribute.CURRENT_PAGE, PagePath.HOME);
        session.setAttribute(SessionAttribute.LANGUAGE, EN);
        logger.info(SESSION_CREATED);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info(se.getSession() + " destroyed");
    }
}
