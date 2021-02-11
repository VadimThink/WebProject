package edu.epam.finalproject.service;

import edu.epam.finalproject.connection.ConnectionPool;
import edu.epam.finalproject.constant.RoleType;
import edu.epam.finalproject.constant.StatusType;
import edu.epam.finalproject.dao.DaoException;
import edu.epam.finalproject.dao.impl.UserDaoImpl;
import edu.epam.finalproject.entity.User;
import edu.epam.finalproject.util.DateToSqlConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.Date;

public class UserService {
    private static final Logger logger = LogManager.getLogger();
    private static final String DATABASE_ERROR = "Can`t get access to Database";

    public boolean createNewUser(String login, String password) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        userDaoImpl.setConnection(connection);
        if (checkUserByLoginAndPassword(login, password)) {
            return false;
        } else {
            try {
                User newUser = new User(login, password, null, null, StatusType.UNACTIVE.getNumber(), 0, RoleType.USER.getNumber());// TODO: 11.02.2021
                userDaoImpl.create(newUser);
            } catch (DaoException e) {
                e.printStackTrace();
                logger.error(DATABASE_ERROR, e);
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
            logger.error(DATABASE_ERROR, e);
        }
        return isExist;
    }

    public boolean checkAdminRole(String login) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        userDaoImpl.setConnection(connection);
        int role = 0;
        try {
            role = userDaoImpl.findRole(login);
        } catch (DaoException e) {
            e.printStackTrace();
            logger.error(DATABASE_ERROR, e);
        }
        return role == RoleType.ADMIN.getNumber();
    }

    public boolean updateUserFormData(String login, String firstName, String lastName, String thirdName,
                                      String birthday, String country, String locality, String address, String phone,
                                      String email, int specialtyNum, int gpa, int languageScore, int mathScore,
                                      int thirdScore){
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        userDaoImpl.setConnection(connection);
        Date birthdayDate = DateToSqlConverter.convert(birthday);
        try {
            userDaoImpl.updateUserFirstName(login, firstName);
            userDaoImpl.updateUserLastName(login, lastName);
            userDaoImpl.updateUserThirdName(login, thirdName);
            userDaoImpl.updateUserBirthday(login, birthdayDate);
            userDaoImpl.updateUserCountry(login, country);
            userDaoImpl.updateUserLocality(login, locality);
            userDaoImpl.updateUserAddress(login, address);
            userDaoImpl.updateUserPhone(login, phone);
            userDaoImpl.updateUserEmail(login, email);
            userDaoImpl.updateUserSpecialtyNum(login, specialtyNum);
            userDaoImpl.updateUserGpa(login, gpa);
            userDaoImpl.updateUserLanguageScore(login, languageScore);
            userDaoImpl.updateUserMathScore(login, mathScore);
            userDaoImpl.updateUserThirdScore(login, thirdScore);
        }catch (DaoException e){
            logger.error(DATABASE_ERROR, e);
            e.printStackTrace();
        }
        return true;
    }

}
