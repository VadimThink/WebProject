package edu.epam.demoproject.connection;

import edu.epam.demoproject.dao.DaoException;
import edu.epam.demoproject.service.UserDaoService;

public class ConnectionDemo {

    public static void main(String[] args) {
        UserDaoService userDaoService = new UserDaoService();
        try {
            userDaoService.createNewUser("dasdasd", "dsadasdas");
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
