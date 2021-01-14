package edu.epam.demoproject.util;

import edu.epam.demoproject.connection.MySqlDataSourceFactory;
import edu.epam.demoproject.dao.AbstractDao;
import edu.epam.demoproject.dao.EntityTransaction;
import edu.epam.demoproject.dao.UserDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IdGenerator {

    public long findId(){
        UserDao userDao = new UserDao();
        Connection connection = MySqlDataSourceFactory.getConnection();
        userDao.setConnection(connection);
        long id = 0;
        try {
            id = userDao.findMaxUserId();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ++id;
    }
}
