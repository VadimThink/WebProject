package edu.epam.finalproject.service;

import edu.epam.finalproject.entity.*;
import edu.epam.finalproject.dao.DaoException;
import edu.epam.finalproject.dao.EntityTransaction;
import edu.epam.finalproject.dao.impl.UserDaoImpl;
import edu.epam.finalproject.util.DateConverter;
import edu.epam.finalproject.util.ScoreComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);
    private static final String DATABASE_ERROR = "Can`t get access to Database";

    public boolean createNewUser(String login, String password) throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        if (!checkUserByLoginAndPassword(login, password)) {
            try {
                User newUser = new User(login, StatusType.INACTIVE, RoleType.USER);
                userDaoImpl.create(newUser, password);
                entityTransaction.commit();
            } catch (DaoException e) {
                entityTransaction.rollback();
                logger.error(DATABASE_ERROR, e);
                throw new ServiceException(e);
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
                                      int thirdScore) throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        Date birthdayDate = DateConverter.convertStringToSqlDate(birthday);
        int resultScore = gpa + languageScore + mathScore + thirdScore;
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
            userDaoImpl.updateUserResultScore(login, resultScore);
            entityTransaction.commit();
        } catch (DaoException e) {
            logger.error(DATABASE_ERROR, e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return true;
    }

    public List<User> findAllUsers() throws ServiceException {
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

    public List<User> findAllUsersWithCurrentSpecialty(Specialty specialty) throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        List<User> userList;
        try {
            userList = userDaoImpl.findAllUsersWithCurrentSpecialty(specialty);
            entityTransaction.commit();
        } catch (DaoException e) {
            logger.error(DATABASE_ERROR, e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return userList;
    }

    public boolean enrollUsersByCompetition() throws ServiceException {
        ScoreComparator comparator = new ScoreComparator();
        SpecialtyList specialtyList = SpecialtyList.getInstance();
        for (int i = 1; i < specialtyList.size(); i++){
            Specialty specialty = specialtyList.getSpecialty(i);
            List<User> enrolleeListOfThisSpecialty = findAllUsersWithCurrentSpecialty(specialty);
            if(enrolleeListOfThisSpecialty != null) {
                enrolleeListOfThisSpecialty.sort(comparator);
                System.out.println(enrolleeListOfThisSpecialty.toString());
                int counter = 0;
                int index = enrolleeListOfThisSpecialty.size() - 1;
                while (counter < specialty.getPlan() && index >= 0) {
                    String currentUserLogin = enrolleeListOfThisSpecialty.get(index).getLogin();
                    updateUserEnrolled(currentUserLogin, true);
                    counter++;
                    index--;
                }
            }
        }
        return true;
    }

    public boolean updateUserEnrolled(String login, boolean isEnrolled) throws ServiceException{
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        try {
            userDaoImpl.updateUserEnrolled(login, isEnrolled);
            entityTransaction.commit();
        } catch (DaoException e) {
            logger.error(DATABASE_ERROR, e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return true;
    }

    public List<User> findUsersInRange(long firstId, long number) throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        List<User> userList;
        try {
            userList = userDaoImpl.findUsersInRange(firstId, number);
            entityTransaction.commit();
        } catch (DaoException e) {
            logger.error(DATABASE_ERROR, e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return userList;
    }

    public long findNumberOfUsers() throws ServiceException {
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

    public User findUserInfo(String login) throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        User currentUser;
        try {
            currentUser = userDaoImpl.findUserInfo(login);
            entityTransaction.commit();
        } catch (DaoException e) {
            logger.error(DATABASE_ERROR, e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return currentUser;
    }

    /**
     * Update user status boolean.
     *
     * @param login  the login
     * @param status the status
     * @return the boolean
     * @throws ServiceException the service exception
     */
    public boolean updateUserStatus(String login, StatusType status) throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        try {
            userDaoImpl.updateUserStatus(login, status);
            entityTransaction.commit();
        } catch (DaoException e) {
            logger.error(DATABASE_ERROR, e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return true;
    }

    public boolean updateUserRole(String login, RoleType role) throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        try {
            userDaoImpl.updateUserRole(login, role);
            entityTransaction.commit();
        } catch (DaoException e) {
            logger.error(DATABASE_ERROR, e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return true;
    }

    public boolean isUserNotBlocked(String login) throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        StatusType status;
        try {
            status = userDaoImpl.findUserStatus(login);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return status != StatusType.BLOCKED;
    }

}
