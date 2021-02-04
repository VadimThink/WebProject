package edu.epam.demoproject.service;

import edu.epam.demoproject.connection.ConnectionPool;
import edu.epam.demoproject.dao.DaoException;
import edu.epam.demoproject.dao.EntityTransaction;
import edu.epam.demoproject.dao.impl.UserDaoImpl;
import edu.epam.demoproject.entity.User;
import edu.epam.demoproject.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class UserService {
    private static final Logger logger = LogManager.getLogger();
    private static final String DATABASE_ERROR = "Can`t get access to Database";

    public boolean createNewUser(String login, String password) {
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
            } catch (DaoException e) {
                e.printStackTrace();
                logger.error(DATABASE_ERROR);
                entityTransaction.rollback();
            } finally {
                entityTransaction.end();
            }
            return true;
        }
    }

    public boolean checkUserByLoginAndPassword(String login, String password) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        userDaoImpl.setConnection(connection);
        boolean isExist = false;
        try {
            isExist = userDaoImpl.checkUserByLoginAndPassword(login, password);
        } catch (DaoException e) {
            e.printStackTrace();
            logger.error(DATABASE_ERROR);
        }
        return isExist;
    }

}
