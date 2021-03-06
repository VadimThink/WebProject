package edu.epam.finalproject.service;

import edu.epam.finalproject.constant.RoleType;
import edu.epam.finalproject.constant.StatusType;
import edu.epam.finalproject.dao.DaoException;
import edu.epam.finalproject.dao.EntityTransaction;
import edu.epam.finalproject.dao.impl.UserDaoImpl;
import edu.epam.finalproject.entity.User;
import edu.epam.finalproject.util.DateConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.List;

public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);
    private static final String DATABASE_ERROR = "Can`t get access to Database";

    public boolean createNewUser(String login, String password) throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        if (!checkUserByLoginAndPassword(login, password)) {
            try {
                User newUser = new User(login, StatusType.INACTIVE,  RoleType.USER);
                userDaoImpl.create(newUser, password);
                entityTransaction.commit();
            } catch (DaoException e) {
                entityTransaction.rollback();
                e.printStackTrace();
                logger.error(DATABASE_ERROR, e);
            }
            entityTransaction.end();
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUserByLoginAndPassword(String login, String password) throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        boolean isExist;
        try {
            isExist = userDaoImpl.checkUserByLoginAndPassword(login, password);
            entityTransaction.commit();
        } catch (DaoException e) {
            entityTransaction.rollback();
            e.printStackTrace();
            logger.error(DATABASE_ERROR, e);
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return isExist;
    }

    public boolean checkAdminRole(String login) throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        int role;
        try {
            role = userDaoImpl.findRole(login);
            entityTransaction.commit();
        } catch (DaoException e) {
            entityTransaction.rollback();
            logger.error(DATABASE_ERROR, e);
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return role == RoleType.ADMIN.ordinal();
    }

    public boolean updateUserFormData(String login, String firstName, String lastName, String thirdName,
                                      String birthday, String country, String locality, String address, String phone,
                                      String email, int specialtyNum, int gpa, int languageScore, int mathScore,
                                      int thirdScore) throws ServiceException{
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        Date birthdayDate = DateConverter.convertStringToSqlDate(birthday);
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
            entityTransaction.commit();
        }catch (DaoException e){
            logger.error(DATABASE_ERROR, e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return true;
    }

    public List<User> findAllUsers() throws ServiceException{
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        List<User> userList;
        try {
            userList = userDaoImpl.findAll();
            entityTransaction.commit();
        } catch (DaoException e) {
            logger.error(DATABASE_ERROR, e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return userList;
    }

    public List<User> findUsersInRange(long firstId, long number) throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        List<User> userList;
        try{
            userList = userDaoImpl.findUsersInRange(firstId, number);
            entityTransaction.commit();
        }catch (DaoException e){
            logger.error(DATABASE_ERROR, e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return userList;
    }

    public long findNumberOfUsers() throws ServiceException{
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        long number;
        try {
            number = userDaoImpl.findMaxUserId();
            entityTransaction.commit();
        } catch (DaoException e) {
            logger.error(DATABASE_ERROR, e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return number;
    }

    public User findUserInfo(String login) throws ServiceException{
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        User currentUser;
        try{
            currentUser = userDaoImpl.findUserInfo(login);
            entityTransaction.commit();
        }catch (DaoException e){
            logger.error(DATABASE_ERROR, e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return currentUser;
    }

    public boolean updateUserStatus(String login, StatusType status) throws ServiceException{
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        try {
            userDaoImpl.updateUserStatus(login, status);
            entityTransaction.commit();
        }catch (DaoException e){
            logger.error(DATABASE_ERROR, e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return true;
    }

    public boolean updateUserRole(String login, RoleType role) throws ServiceException{
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        try {
            userDaoImpl.updateUserRole(login, role);
            entityTransaction.commit();
        }catch (DaoException e){
            logger.error(DATABASE_ERROR, e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return true;
    }

    public boolean isUserNotBlocked(String login) throws ServiceException{
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        StatusType status;
        try {
            status = userDaoImpl.findUserStatus(login);
        }catch (DaoException e){
            throw new ServiceException(e);
        }
        return status != StatusType.BLOCKED;
    }

}
