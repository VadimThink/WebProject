package edu.epam.demoproject.dao;

import edu.epam.demoproject.entity.User;

public abstract class AbstractUserDao extends AbstractDao<Long, User> {

    public abstract long findMaxUserId() throws DaoException;
    public abstract boolean checkUserByLoginAndPassword(String login, String password) throws DaoException;
    public abstract void blockUser(User user) throws DaoException;
    public abstract User updateUserId(User user) throws DaoException;
    public abstract int findRole(String login) throws DaoException;

}
