package edu.epam.demoproject.service;

import edu.epam.demoproject.connection.ConnectionPool;
import edu.epam.demoproject.constant.RoleType;
import edu.epam.demoproject.dao.DaoException;
import edu.epam.demoproject.dao.EntityTransaction;
import edu.epam.demoproject.dao.impl.UserDaoImpl;
import edu.epam.demoproject.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;

public class UserService {
    private static final Logger logger = LogManager.getLogger();
    private static final String DATABASE_ERROR = "Can`t get access to Database";

    public boolean createNewUser(String login, String password) {
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
                User newUser = new User(login, password, null, null, 2, 0, RoleType.USER.getNumber());
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

    public boolean checkAdminRole(String login){
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        userDaoImpl.setConnection(connection);
        int role = 0;
        try{
            role = userDaoImpl.findRole(login);
        }catch (DaoException e){
            e.printStackTrace();
            logger.error(DATABASE_ERROR);
        }
        return role == RoleType.ADMIN.getNumber();
    }

}
