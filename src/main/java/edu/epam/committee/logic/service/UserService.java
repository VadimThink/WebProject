package edu.epam.committee.logic.service;

import edu.epam.committee.dao.DaoException;
import edu.epam.committee.dao.EntityTransaction;
import edu.epam.committee.dao.impl.UserDaoImpl;
import edu.epam.committee.entity.RoleType;
import edu.epam.committee.entity.Specialty;
import edu.epam.committee.entity.SpecialtyList;
import edu.epam.committee.entity.StatusType;
import edu.epam.committee.entity.User;
import edu.epam.committee.util.DateConverter;
import edu.epam.committee.util.ScoreComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.List;

/**
 * The type User service.
 */
public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);

    /**
     * Create new user boolean.
     *
     * @param login    the login
     * @param password the password
     * @return the boolean
     * @throws ServiceException the service exception
     */
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
                logger.error(e);
                throw new ServiceException(e);
            }
            entityTransaction.end();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check user by login and password boolean.
     *
     * @param login    the login
     * @param password the password
     * @return the boolean
     * @throws ServiceException the service exception
     */
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
            logger.error(e);
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return isExist;
    }

    /**
     * Check admin role boolean.
     *
     * @param login the login
     * @return the boolean
     * @throws ServiceException the service exception
     */
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
            logger.error(e);
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return role == RoleType.ADMIN.ordinal();
    }

    /**
     * Update user form data boolean.
     *
     * @param login         the login
     * @param firstName     the first name
     * @param lastName      the last name
     * @param thirdName     the third name
     * @param birthday      the birthday
     * @param country       the country
     * @param locality      the locality
     * @param address       the address
     * @param phone         the phone
     * @param email         the email
     * @param specialtyNum  the specialty num
     * @param gpa           the gpa
     * @param languageScore the language score
     * @param mathScore     the math score
     * @param thirdScore    the third score
     * @return the boolean
     * @throws ServiceException the service exception
     */
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
            logger.error(e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return true;
    }

    /**
     * Find all users.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    public List<User> findAllUsers() throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        List<User> userList;
        try {
            userList = userDaoImpl.findAll();
            entityTransaction.commit();
        } catch (DaoException e) {
            logger.error(e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return userList;
    }

    /**
     * Find all users with current specialty.
     *
     * @param specialtyNum the specialty num
     * @return the list
     * @throws ServiceException the service exception
     */
    public List<User> findAllUsersWithCurrentSpecialty(int specialtyNum) throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        List<User> userList;
        try {
            userList = userDaoImpl.findAllUsersWithCurrentSpecialty(specialtyNum);
            entityTransaction.commit();
        } catch (DaoException e) {
            logger.error(e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return userList;
    }

    /**
     * Enroll users by competition boolean.
     *
     * @return the boolean
     * @throws ServiceException the service exception
     */
    public boolean enrollUsersByCompetition() throws ServiceException {
        ScoreComparator comparator = new ScoreComparator();
        SpecialtyList specialtyList = SpecialtyList.getInstance();
        for (int i = 1; i < specialtyList.size(); i++) {
            Specialty specialty = specialtyList.getSpecialty(i);
            List<User> enrolleeListOfThisSpecialty = findAllUsersWithCurrentSpecialty(specialty.getSpecialtyNum());
            if (enrolleeListOfThisSpecialty != null) {
                enrolleeListOfThisSpecialty.sort(comparator);
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

    /**
     * Update user enrolled boolean.
     *
     * @param login      the login
     * @param isEnrolled the is enrolled
     * @return the boolean
     * @throws ServiceException the service exception
     */
    public boolean updateUserEnrolled(String login, boolean isEnrolled) throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        try {
            userDaoImpl.updateUserEnrolled(login, isEnrolled);
            entityTransaction.commit();
        } catch (DaoException e) {
            logger.error(e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return true;
    }

    /**
     * Find users in range.
     *
     * @param firstId the first id
     * @param number  the number
     * @return the list
     * @throws ServiceException the service exception
     */
    public List<User> findUsersInRange(long firstId, long number) throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        List<User> userList;
        try {
            userList = userDaoImpl.findUsersInRange(firstId, number);
            entityTransaction.commit();
        } catch (DaoException e) {
            logger.error(e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return userList;
    }

    /**
     * Find number of users.
     *
     * @return the long
     * @throws ServiceException the service exception
     */
    public long findNumberOfUsers() throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        long number;
        try {
            number = userDaoImpl.findMaxUserId();
            entityTransaction.commit();
        } catch (DaoException e) {
            logger.error(e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return number;
    }

    /**
     * Find user info.
     *
     * @param login the login
     * @return the user
     * @throws ServiceException the service exception
     */
    public User findUserInfo(String login) throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        User currentUser;
        try {
            currentUser = userDaoImpl.findUserInfo(login);
            entityTransaction.commit();
        } catch (DaoException e) {
            logger.error(e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return currentUser;
    }

    /**
     * Update user status.
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
            logger.error(e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return true;
    }

    /**
     * Update user role.
     *
     * @param login the login
     * @param role  the role
     * @return the boolean
     * @throws ServiceException the service exception
     */
    public boolean updateUserRole(String login, RoleType role) throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        try {
            userDaoImpl.updateUserRole(login, role);
            entityTransaction.commit();
        } catch (DaoException e) {
            logger.error(e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return true;
    }

    /**
     * Is user not blocked boolean.
     *
     * @param login the login
     * @return the boolean
     * @throws ServiceException the service exception
     */
    public boolean isUserNotBlocked(String login) throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        entityTransaction.begin(userDaoImpl);
        StatusType status;
        try {
            status = userDaoImpl.findUserStatus(login);
        } catch (DaoException e) {
            logger.error(e);
            throw new ServiceException(e);
        }
        return status != StatusType.BLOCKED;
    }

}
