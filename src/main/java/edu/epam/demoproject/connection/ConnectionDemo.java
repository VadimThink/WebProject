package edu.epam.demoproject.connection;

import edu.epam.demoproject.dao.EntityTransaction;
import edu.epam.demoproject.dao.UserDao;
import edu.epam.demoproject.entity.User;
import edu.epam.demoproject.service.UserDaoService;
import edu.epam.demoproject.util.IdGenerator;

import java.sql.*;

public class ConnectionDemo {

    public static void main(String[] args) {
        UserDaoService userDaoService = new UserDaoService();
        userDaoService.createNewUser("dasdasd", "dsadasdas");
    }
}
