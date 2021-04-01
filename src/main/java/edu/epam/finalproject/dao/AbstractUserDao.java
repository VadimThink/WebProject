package edu.epam.finalproject.dao;

import edu.epam.finalproject.entity.RoleType;
import edu.epam.finalproject.entity.StatusType;
import edu.epam.finalproject.entity.User;

import java.sql.Date;
import java.util.List;

/**
 * The type Abstract user dao.
 */
public abstract class AbstractUserDao extends AbstractDao<User> {

    /**
     * Find max user id long.
     *
     * @return the long
     * @throws DaoException the dao exception
     */
    public abstract long findMaxUserId() throws DaoException;

    /**
     * Find user info.
     *
     * @param login the login
     * @return the user
     * @throws DaoException the dao exception
     */
    public abstract User findUserInfo(String login) throws DaoException;

    /**
     * Find users in range.
     *
     * @param firstId the first id
     * @param number  the number
     * @return the list
     * @throws DaoException the dao exception
     */
    public abstract List<User> findUsersInRange(long firstId, long number) throws DaoException;

    /**
     * Find all users with current specialty.
     *
     * @param specialtyNum the specialty num
     * @return the list
     * @throws DaoException the dao exception
     */
    public abstract List<User> findAllUsersWithCurrentSpecialty(int specialtyNum) throws DaoException;

    /**
     * Check user by login and password.
     *
     * @param login    the login
     * @param password the password
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean checkUserByLoginAndPassword(String login, String password) throws DaoException;

    /**
     * Find role.
     *
     * @param login the login
     * @return the int
     * @throws DaoException the dao exception
     */
    public abstract int findRole(String login) throws DaoException;

    /**
     * Update user login.
     *
     * @param previousLogin the previous login
     * @param newLogin      the new login
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean updateUserLogin(String previousLogin, String newLogin) throws DaoException;

    /**
     * Update user password.
     *
     * @param login    the login
     * @param password the password
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean updateUserPassword(String login, String password) throws DaoException;

    /**
     * Update user role.
     *
     * @param login    the login
     * @param roleType the role type
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean updateUserRole(String login, RoleType roleType) throws DaoException;

    /**
     * Update user status.
     *
     * @param login      the login
     * @param statusType the status type
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean updateUserStatus(String login, StatusType statusType) throws DaoException;

    /**
     * Update user first name.
     *
     * @param login     the login
     * @param firstName the first name
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean updateUserFirstName(String login, String firstName) throws DaoException;

    /**
     * Update user last name.
     *
     * @param login    the login
     * @param lastName the last name
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean updateUserLastName(String login, String lastName) throws DaoException;

    /**
     * Update user third name.
     *
     * @param login     the login
     * @param thirdName the third name
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean updateUserThirdName(String login, String thirdName) throws DaoException;

    /**
     * Update user birthday.
     *
     * @param login    the login
     * @param birthday the birthday
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean updateUserBirthday(String login, Date birthday) throws DaoException;

    /**
     * Update user country.
     *
     * @param login   the login
     * @param country the country
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean updateUserCountry(String login, String country) throws DaoException;

    /**
     * Update user locality.
     *
     * @param login    the login
     * @param locality the locality
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean updateUserLocality(String login, String locality) throws DaoException;

    /**
     * Update user address.
     *
     * @param login   the login
     * @param address the address
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean updateUserAddress(String login, String address) throws DaoException;

    /**
     * Update user phone.
     *
     * @param login the login
     * @param phone the phone
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean updateUserPhone(String login, String phone) throws DaoException;

    /**
     * Update user email.
     *
     * @param login the login
     * @param email the email
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean updateUserEmail(String login, String email) throws DaoException;

    /**
     * Update user specialty num.
     *
     * @param login        the login
     * @param specialtyNum the specialty num
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean updateUserSpecialtyNum(String login, int specialtyNum) throws DaoException;

    /**
     * Update user gpa.
     *
     * @param login the login
     * @param gpa   the gpa
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean updateUserGpa(String login, int gpa) throws DaoException;

    /**
     * Update user language score.
     *
     * @param login         the login
     * @param languageScore the language score
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean updateUserLanguageScore(String login, int languageScore) throws DaoException;

    /**
     * Update user math score.
     *
     * @param login     the login
     * @param mathScore the math score
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean updateUserMathScore(String login, int mathScore) throws DaoException;

    /**
     * Update user third score.
     *
     * @param login      the login
     * @param thirdScore the third score
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean updateUserThirdScore(String login, int thirdScore) throws DaoException;

    /**
     * Update user result score.
     *
     * @param login       the login
     * @param resultScore the result score
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean updateUserResultScore(String login, int resultScore) throws DaoException;

    /**
     * Update user enrolled.
     *
     * @param login      the login
     * @param isEnrolled the is enrolled
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean updateUserEnrolled(String login, boolean isEnrolled) throws DaoException;

    /**
     * Find user status.
     *
     * @param login the login
     * @return the status type
     * @throws DaoException the dao exception
     */
    public abstract StatusType findUserStatus(String login) throws DaoException;

    /**
     * Create user.
     *
     * @param user     the user
     * @param password the password
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean create(User user, String password) throws DaoException;
}
