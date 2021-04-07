package edu.epam.committee.controller.request;

import java.util.Map;
import java.util.Set;

public class RequestContext {
    private final Map<String, Object> requestAttributes;
    private final Map<String, Object> sessionAttributes;
    private final Map<String, String[]> requestParameters;
    private final String requestHeader;

    public RequestContext(Map<String, Object> requestAttributes,
                          Map<String, String[]> requestParameters,
                          Map<String, Object> sessionAttributes,
                          String requestHeader) {
        this.requestAttributes = requestAttributes;
        this.requestParameters = requestParameters;
        this.sessionAttributes = sessionAttributes;
        this.requestHeader = requestHeader;
    }

    public String getParameter(String parameterName) {
        String[] parameters = requestParameters.get(parameterName);
        if (parameters == null) {
            return null;
        }
        return parameters[0];
    }

    public void addAttribute(String attributeName, Object attributeContent) {
        requestAttributes.put(attributeName, attributeContent);
    }

    public Set<String> getAttributeNames() {
        return requestAttributes.keySet();
    }

    public Object getAttribute(String attributeName) {
        return requestAttributes.get(attributeName);
    }

    public void addSessionAttribute(String attributeName, Object attributeContent) {
        sessionAttributes.put(attributeName, attributeContent);
    }

    public void removeSessionAttribute(String attributeName) {
        sessionAttributes.remove(attributeName);
    }

    public Set<String> getSessionAttributeNames() {
        return sessionAttributes.keySet();
    }

    public Object getSessionAttribute(String attributeName) {
        return sessionAttributes.get(attributeName);
    }

    public String getHeader() {
        return requestHeader;
    }

}
