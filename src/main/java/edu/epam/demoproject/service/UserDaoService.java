package edu.epam.demoproject.service;

import edu.epam.demoproject.connection.MySqlDataSourceFactory;
import edu.epam.demoproject.dao.EntityTransaction;
import edu.epam.demoproject.dao.UserDao;
import edu.epam.demoproject.entity.User;
import edu.epam.demoproject.util.IdGenerator;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoService {

    public boolean createNewUser(String login, String password){
        IdGenerator idGenerator = new IdGenerator();
        long id = idGenerator.findId();
        Connection connection = MySqlDataSourceFactory.getConnection();
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDao userDao = new UserDao();
        userDao.setConnection(connection);
        entityTransaction.begin(userDao);
        if (checkUserByLoginAndPassword(login, password)){
            return false;
        }else {
            try {
                User newUser = new User(id, login, password, null, null, 2, 0, 0);
                userDao.create(newUser);
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

    public boolean checkUserByLoginAndPassword(String login, String password){
        Connection connection = MySqlDataSourceFactory.getConnection();
        UserDao userDao = new UserDao();
        userDao.setConnection(connection);
        boolean isExist = false;
        try {
            isExist = userDao.checkUserByLoginAndPassword(login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isExist;
    }

}
