package edu.epam.demoproject.controller.request;

import edu.epam.demoproject.constant.Attribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

public class RequestFiller {
    public void fillData(HttpServletRequest request, RequestContext requestContext) {
        Set<String> requestAttributeNames = requestContext.getAttributeNames();
        for (String attributeName : requestAttributeNames) {
            Object attributeValue = requestContext.getAttribute(attributeName);
            request.setAttribute(attributeName, attributeValue);
        }

        HttpSession session = request.getSession();
        Set<String> sessionAttributeNames = requestContext.getSessionAttributeNames();
        if (sessionAttributeNames.contains(Attribute.INVALIDATE_ATTRIBUTE)) {
            session.invalidate();
        } else {
            for (String attributeName : sessionAttributeNames) {
                Object attributeValue = requestContext.getSessionAttribute(attributeName);
                session.setAttribute(attributeName, attributeValue);
            }
        }
    }
}
