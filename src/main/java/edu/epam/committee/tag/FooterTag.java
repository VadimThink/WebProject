package edu.epam.committee.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class FooterTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        String footer = "<p style=\"color: white\">©\"THINK\"  </p>";
        try {
            JspWriter out = pageContext.getOut();
            out.write(footer);
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }
}
