package edu.epam.demoproject.dao;

import edu.epam.demoproject.entity.User;

import java.sql.SQLException;

public abstract class AbstractUserDao extends AbstractDao<Long, User> {

    public abstract long findMaxUserId() throws SQLException;
    public abstract boolean checkUserByLoginAndPassword(String login, String password) throws SQLException;
    public abstract void blockUser(User user);
    public abstract User updateUserId(User user);

}
