package edu.epam.demoproject.command;

public class PagePath {

    private PagePath(){

    }

    public static final String LOGIN = "/pages/index.jsp";
    public static final String REGISTRATION = "/pages/registration.jsp";
    public static final String MAIN = "/pages/main.jsp";

    public static final String ERROR_404 = "/pages/error/error404.jsp";
    public static final String WRONG_AUTH = "/pages/wrongLoginOrPassword.jsp";
    public static final String USER_EXIST = "/pages/thisUserIsExist.jsp";
}
