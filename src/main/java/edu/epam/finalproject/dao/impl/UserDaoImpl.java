package edu.epam.finalproject.dao.impl;

import edu.epam.finalproject.dao.AbstractUserDao;
import edu.epam.finalproject.dao.DaoException;
import edu.epam.finalproject.dao.SqlRequest;
import edu.epam.finalproject.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static edu.epam.finalproject.dao.SqlRequest.*;

public class UserDaoImpl extends AbstractUserDao {

    @Override
    public long findMaxUserId() throws DaoException {
        long id;
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_FIND_MAX_ID);
            resultSet.next();
            id = resultSet.getLong(1);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return id;
    }

    @Override
    public List<User> findAll() throws DaoException {
        List<User> usersList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL_USERS);
            while (resultSet.next()) {
                String login = resultSet.getString(1);
                int statusNum = resultSet.getInt(2);
                int roleNum = resultSet.getInt(3);
                long id = resultSet.getLong(4);
                User user = new User(id, login, StatusType.values()[statusNum], RoleType.values()[roleNum]);
                usersList.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return usersList;
    }

    @Override
    public List<User> findUsersInRange(long firstId, long number) throws DaoException {
        List<User> usersList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQL_FIND_USERS_IN_RANGE)) {
            statement.setLong(1, firstId);
            statement.setLong(2, number);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String login = resultSet.getString(1);
                int statusNum = resultSet.getInt(2);
                long id = resultSet.getLong(3);
                int roleNum = resultSet.getInt(4);
                User user = new User(id, login, StatusType.values()[statusNum], RoleType.values()[roleNum]);
                usersList.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return usersList;
    }

    @Override
    public List<User> findAllUsersWithCurrentSpecialty(int specialtyNum) throws DaoException {
        List<User> userList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL_USERS_WITH_CURRENT_SPECIALTY)) {
            statement.setInt(1, specialtyNum);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String login = resultSet.getString(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String thirdName = resultSet.getString(4);
                int resultScore = resultSet.getInt(5);
                int enrolled = resultSet.getInt(6);
                User user = new User(login, firstName, lastName, thirdName, resultScore, enrolled);
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return userList;
    }

    @Override
    public User findUserInfo(String login) throws DaoException {
        User currentUser;
        try (PreparedStatement statement = connection.prepareStatement(SQL_FIND_USER_INFO)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            String firstName = resultSet.getString(1);
            String lastName = resultSet.getString(2);
            String thirdName = resultSet.getString(3);
            String birthday = resultSet.getString(4);
            String country = resultSet.getString(5);
            String locality = resultSet.getString(6);
            String address = resultSet.getString(7);
            String phone = resultSet.getString(8);
            String email = resultSet.getString(9);
            int specialtyNum = resultSet.getInt(10);
            int gpa = resultSet.getInt(11);
            int languageScore = resultSet.getInt(12);
            int mathScore = resultSet.getInt(13);
            int thirdScore = resultSet.getInt(14);
            int resultScore = resultSet.getInt(15);
            int enrolled = resultSet.getInt(16);
            Specialty specialty = SpecialtyList.getInstance().getSpecialtyList().get(specialtyNum);
            currentUser = new User(specialty, firstName, lastName, thirdName, birthday, country, locality, address,
                    phone, email, gpa, languageScore, mathScore, thirdScore, resultScore, enrolled);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return currentUser;
    }

    @Override
    public boolean checkUserByLoginAndPassword(String login, String password) throws DaoException {
        boolean isPresent;
        try (PreparedStatement statement = connection.prepareStatement(SQL_CHECK_USER_BY_LOGIN_AND_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            isPresent = resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return isPresent;
    }

    public int findRole(String login) throws DaoException {
        int role;
        try (PreparedStatement statement = connection.prepareStatement(SQL_FIND_ROLE)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            role = resultSet.getInt(1);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return role;
    }

    @Override
    public boolean updateUserLogin(String previousLogin, String newLogin) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_LOGIN)) {
            statement.setString(1, newLogin);
            statement.setString(2, previousLogin);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public boolean updateUserPassword(String login, String password) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PASSWORD)) {
            statement.setString(1, password);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public boolean updateUserRole(String login, RoleType roleType) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_ROLE_NUM)) {
            statement.setInt(1, roleType.ordinal());
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public boolean updateUserStatus(String login, StatusType statusType) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_STATUS_NUM)) {
            statement.setInt(1, statusType.ordinal());
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public boolean updateUserFirstName(String login, String firstName) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_FIRST_NAME)) {
            statement.setString(1, firstName);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public boolean updateUserLastName(String login, String lastName) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_LAST_NAME)) {
            statement.setString(1, lastName);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public boolean updateUserThirdName(String login, String thirdName) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_THIRD_NAME)) {
            statement.setString(1, thirdName);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public boolean updateUserBirthday(String login, Date birthday) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_BIRTHDAY)) {
            statement.setDate(1, birthday);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public boolean updateUserCountry(String login, String country) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_COUNTRY)) {
            statement.setString(1, country);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public boolean updateUserLocality(String login, String locality) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_LOCALITY)) {
            statement.setString(1, locality);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public boolean updateUserAddress(String login, String address) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_ADDRESS)) {
            statement.setString(1, address);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public boolean updateUserPhone(String login, String phone) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PHONE)) {
            statement.setString(1, phone);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public boolean updateUserEmail(String login, String email) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_EMAIL)) {
            statement.setString(1, email);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public boolean updateUserSpecialtyNum(String login, int specialtyNum) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_SPECIALTY_NUM)) {
            statement.setInt(1, specialtyNum);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public boolean updateUserGpa(String login, int gpa) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_GPA)) {
            statement.setInt(1, gpa);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public boolean updateUserLanguageScore(String login, int languageScore) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_LANGUAGE_SCORE)) {
            statement.setInt(1, languageScore);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public boolean updateUserMathScore(String login, int mathScore) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_MATH_SCORE)) {
            statement.setInt(1, mathScore);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public boolean updateUserThirdScore(String login, int thirdScore) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_THIRD_SCORE)) {
            statement.setInt(1, thirdScore);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public boolean updateUserResultScore(String login, int resultScore) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_RESULT_SCORE)) {
            statement.setInt(1, resultScore);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public boolean updateUserEnrolled(String login, boolean isEnrolled) throws DaoException {
        int enrolledValue;
        if (isEnrolled)
            enrolledValue = 1;
        else
            enrolledValue = 0;
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_ENROLLED)) {
            statement.setInt(1, enrolledValue);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public StatusType findUserStatus(String login) throws DaoException {
        int statusNum;
        try (PreparedStatement statement = connection.prepareStatement(SQL_FIND_STATUS)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            statusNum = resultSet.getInt(1);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return StatusType.values()[statusNum];
    }

    @Override
    public boolean create(User user, String password) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SqlRequest.SQL_CREATE)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, password);
            statement.setInt(3, user.getStatus().ordinal());
            statement.setInt(4, user.getRole().ordinal());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

}