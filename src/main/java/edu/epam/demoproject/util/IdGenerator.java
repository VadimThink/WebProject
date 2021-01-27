package edu.epam.demoproject.util;

import edu.epam.demoproject.connection.MysqlDataSourceFactory;
import edu.epam.demoproject.dao.impl.UserDaoImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class IdGenerator {

    public long findId(){
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        Connection connection = MysqlDataSourceFactory.getConnection();
        userDaoImpl.setConnection(connection);
        long id = 0;
        try {
            id = userDaoImpl.findMaxUserId();
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
