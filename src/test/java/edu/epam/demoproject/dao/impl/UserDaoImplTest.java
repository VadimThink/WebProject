package edu.epam.demoproject.dao.impl;

import edu.epam.demoproject.connection.ConnectionPool;
import edu.epam.demoproject.dao.DaoException;
import org.testng.annotations.Test;

import java.sql.Connection;

import static org.testng.Assert.*;

public class UserDaoImplTest {

    @Test
    public void testUpdateUserLogin() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        userDaoImpl.setConnection(connection);
        boolean actual = false;
        try {
            actual = userDaoImpl.updateUserLogin("loch1", "loch2");
        } catch (DaoException e) {
            e.printStackTrace();
        }
        assertTrue(actual);
    }
}