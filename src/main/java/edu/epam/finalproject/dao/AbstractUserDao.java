package edu.epam.finalproject.dao;

import edu.epam.finalproject.entity.RoleType;
import edu.epam.finalproject.entity.Specialty;
import edu.epam.finalproject.entity.StatusType;
import edu.epam.finalproject.entity.User;

import java.sql.Date;
import java.util.List;

public abstract class AbstractUserDao extends AbstractDao<Long, User> {

    public abstract long findMaxUserId() throws DaoException;
    public abstract User findUserInfo(String login) throws DaoException;
    public abstract List<User> findUsersInRange(long firstId, long number) throws DaoException;
    public abstract List<User> findAllUsersWithCurrentSpecialty(Specialty specialty) throws DaoException;
    public abstract boolean checkUserByLoginAndPassword(String login, String password) throws DaoException;
    public abstract int findRole(String login) throws DaoException;
    public abstract boolean updateUserLogin(String previousLogin, String newLogin) throws DaoException;
    public abstract boolean updateUserPassword(String login, String password) throws DaoException;
    public abstract boolean updateUserRole(String login, RoleType roleType) throws DaoException;
    public abstract boolean updateUserStatus(String login, StatusType statusType) throws DaoException;
    public abstract boolean updateUserFirstName(String login, String firstName) throws DaoException;
    public abstract boolean updateUserLastName(String login, String lastName) throws DaoException;
    public abstract boolean updateUserThirdName(String login, String thirdName) throws DaoException;
    public abstract boolean updateUserBirthday(String login, Date birthday) throws DaoException;
    public abstract boolean updateUserCountry(String login, String country) throws DaoException;
    public abstract boolean updateUserLocality(String login, String locality) throws DaoException;
    public abstract boolean updateUserAddress(String login, String address) throws DaoException;
    public abstract boolean updateUserPhone(String login, String phone) throws DaoException;
    public abstract boolean updateUserEmail(String login, String email) throws DaoException;
    public abstract boolean updateUserSpecialtyNum(String login, int specialtyNum) throws DaoException;
    public abstract boolean updateUserGpa(String login, int gpa) throws DaoException;
    public abstract boolean updateUserLanguageScore(String login, int languageScore) throws DaoException;
    public abstract boolean updateUserMathScore(String login, int mathScore) throws DaoException;
    public abstract boolean updateUserThirdScore(String login, int thirdScore) throws DaoException;
    public abstract boolean updateUserResultScore(String login, int resultScore) throws DaoException;
    public abstract boolean updateUserEnrolled(String login, boolean isEnrolled) throws DaoException;
    public abstract StatusType findUserStatus(String login) throws DaoException;

    public abstract boolean create(User user, String password) throws DaoException;
}
