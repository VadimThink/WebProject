package edu.epam.finalproject.command;

public class PagePath {

    public static final String LOGIN = "WEB-INF/pages/login.jsp";
    public static final String REGISTRATION = "WEB-INF/pages/registration.jsp";
    public static final String ADMIN_MENU = "WEB-INF/pages/admin.jsp";
    public static final String USER_MENU = "WEB-INF/pages/user.jsp";
    public static final String FORM = "WEB-INF/pages/form.jsp";
    public static final String HOME = "WEB-INF/pages/home.jsp";
    public static final String FIC = "WEB-INF/pages/fic.jsp";
    public static final String FITC = "WEB-INF/pages/fitc.jsp";
    public static final String FCSN = "WEB-INF/pages/fcsn.jsp";
    public static final String FRE = "WEB-INF/pages/fre.jsp";
    public static final String FEE = "WEB-INF/pages/fee.jsp";
    public static final String FCP = "WEB-INF/pages/fcp.jsp";
    public static final String USERS_LIST = "/controller?command=users_list";
    public static final String USERS = "WEB-INF/pages/users.jsp";
    public static final String USERS_PAGINATION = "/controller?command=users_pagination";
    public static final String PROFILE = "WEB-INF/pages/profile.jsp";
    public static final String PROFILE_COMMAND = "/controller?command=profile&login=";
    public static final String EDIT_PROFILE = "/controller?command=edit_profile&login=";
    public static final String FORM_COMMAND = "/controller?command=form_page&login=";
    public static final String OPEN_MENU_COMMAND = "/controller?command=menu";

    public static final String ERROR_404 = "WEB-INF/pages/error/error404.jsp";
    public static final String ERROR_500 = "WEB-INF/pages/error/error500.jsp";

    private PagePath() {

    }
}
