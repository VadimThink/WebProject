package edu.epam.finalproject.command;

public class PagePath {

    public static final String LOGIN = "/pages/login.jsp";
    public static final String REGISTRATION = "/pages/registration.jsp";
    public static final String ADMIN_MENU = "/pages/admin.jsp";
    public static final String USER_MENU = "/pages/user.jsp";
    public static final String FORM = "/pages/form.jsp";
    public static final String HOME = "/pages/home.jsp";
    public static final String FIC = "/pages/fic.jsp";
    public static final String FITC = "/pages/fitc.jsp";
    public static final String FCSN = "/pages/fcsn.jsp";
    public static final String FRE = "/pages/fre.jsp";
    public static final String FEE = "/pages/fee.jsp";
    public static final String FCP = "/pages/fcp.jsp";
    public static final String USERS_LIST = "/controller?command=users_list";
    public static final String USERS = "/pages/users.jsp";
    public static final String USERS_PAGINATION = "/controller?command=users_pagination";
    public static final String PROFILE = "/pages/profile.jsp";
    public static final String PROFILE_COMMAND = "/controller?command=profile&login=";

    public static final String ERROR_404 = "/pages/error/error404.jsp";
    public static final String ERROR_500 = "/pages/error/error500.jsp";

    private PagePath() {

    }
}
