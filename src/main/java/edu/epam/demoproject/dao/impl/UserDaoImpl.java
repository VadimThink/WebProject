package edu.epam.demoproject.dao.impl;

import edu.epam.demoproject.dao.AbstractUserDao;
import edu.epam.demoproject.dao.DaoException;
import edu.epam.demoproject.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoImpl extends AbstractUserDao {
    private static final String SQL_CREATE = "INSERT INTO users(id, login, password, first_name, " +
            "last_name, status_num, faculty_num, specialty_num) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final static String SQL_FIND_MAX_ID = "SELECT MAX(users.id) FROM users";
    private final static String SQL_CHECK_USER_BY_LOGIN_AND_PASSWORD = "SELECT users.login, users.password FROM users " +
            "WHERE users.login LIKE ? AND users.password LIKE ?";

    void createSeveralUsers(List<User> users) {

    }

    @Override
    public void blockUser(User user) {

    }

    @Override
    public User updateUserId(User user) {
        return null;
    }

    @Override
    public long findMaxUserId() throws DaoException {
        long id;
        try (Statement statement = connection.createStatement();){
            ResultSet resultSet = statement.executeQuery(SQL_FIND_MAX_ID);
            resultSet.next();
            id = resultSet.getLong("MAX(users.id)");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return id;
    }

    @Override
    public boolean checkUserByLoginAndPassword(String login, String password) throws DaoException {
        boolean isPresent;
        try (PreparedStatement statement = connection.prepareStatement(SQL_CHECK_USER_BY_LOGIN_AND_PASSWORD)){
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            isPresent = resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return isPresent;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }


    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }


    @Override
    public void create(User user) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_CREATE)){
            statement.setLong(1, user.getId());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.setInt(6, user.getStatusNum());
            statement.setInt(7, user.getFacultyNum());
            statement.setInt(8, user.getSpecialtyNum());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public User update(User user) {
        return null;
    }

}