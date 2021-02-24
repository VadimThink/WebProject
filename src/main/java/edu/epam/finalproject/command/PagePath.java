package edu.epam.finalproject.command;

public class PagePath {

    private PagePath() {

    }

    public static final String LOGIN = "/pages/login.jsp";
    public static final String REGISTRATION = "/pages/registration.jsp";
    public static final String ADMIN = "/pages/admin.jsp";
    public static final String USER = "/pages/user.jsp";
    public static final String FORM = "/pages/form.jsp";
    public static final String USERS_LIST = "/controller?command=users_list";
    public static final String USERS = "/pages/users.jsp";
    public static final String USERS_PAGINATION = "/controller?command=users_pagination";

    public static final String ERROR_404 = "/pages/error/error404.jsp";
}
