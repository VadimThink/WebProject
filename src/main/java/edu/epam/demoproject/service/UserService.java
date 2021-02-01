package edu.epam.demoproject.service;

import edu.epam.demoproject.connection.ConnectionPool;
import edu.epam.demoproject.dao.DaoException;
import edu.epam.demoproject.dao.EntityTransaction;
import edu.epam.demoproject.dao.impl.UserDaoImpl;
import edu.epam.demoproject.entity.User;
import edu.epam.demoproject.util.IdGenerator;

import java.sql.Connection;
import java.sql.SQLException;

public class UserService {

    public boolean createNewUser(String login, String password) throws DaoException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        IdGenerator idGenerator = new IdGenerator();
        long id = idGenerator.findId();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        userDaoImpl.setConnection(connection);
        entityTransaction.begin(userDaoImpl);
        if (checkUserByLoginAndPassword(login, password)) {
            return false;
        } else {
            try {
                User newUser = new User(id, login, password, null, null, 2, 0, 0);
                userDaoImpl.create(newUser);
                entityTransaction.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                entityTransaction.rollback();
            } finally {
                entityTransaction.end();
            }
            return true;
        }
    }

    public boolean checkUserByLoginAndPassword(String login, String password) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        userDaoImpl.setConnection(connection);
        boolean isExist = false;
        try {
            isExist = userDaoImpl.checkUserByLoginAndPassword(login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isExist;
    }

}
