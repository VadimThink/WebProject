package edu.epam.demoproject.util;

import edu.epam.demoproject.connection.ConnectionPool;
import edu.epam.demoproject.dao.DaoException;
import edu.epam.demoproject.dao.impl.UserDaoImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class IdGenerator {

    public long findId() {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        connection = connectionPool.getConnection();
        userDaoImpl.setConnection(connection);
        long id = 0;
        try {
            id = userDaoImpl.findMaxUserId();
        } catch (DaoException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ++id;
    }
}
