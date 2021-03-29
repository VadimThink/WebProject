package edu.epam.finalproject.dao;

public class SqlRequest {

    public final static String SQL_CREATE = "INSERT INTO users(login, password, " +
            "status_num, role_num) VALUES (?, ?, ?, ?)";
    public final static String SQL_FIND_MAX_ID = "SELECT MAX(users.id) FROM users";
    public final static String SQL_FIND_ALL_USERS = "SELECT users.login, users.status_num, users.role_num, users.id FROM users";
    public static final String SQL_FIND_USERS_IN_RANGE = "SELECT users.login, users.status_num, users.id, users.role_num " +
            " FROM users LIMIT ?,?";
    public final static String SQL_CHECK_USER_BY_LOGIN_AND_PASSWORD = "SELECT users.login, users.password FROM users " +
            "WHERE users.login LIKE ? AND users.password LIKE ?";
    public final static String SQL_FIND_USER_INFO = "SELECT users.first_name, users.last_name, users.third_name," +
            "users.birthday, users.country, users.locality, users.address, users.phone, users.email, users.specialty_num," +
            "users.gpa, users.language_score, users.math_score, users.third_score, users.result_score, users.enrolled " +
            "FROM users WHERE users.login LIKE ?";
    public final static String SQL_FIND_ALL_USERS_WITH_CURRENT_SPECIALTY = "SELECT users.login, users.first_name," +
            "users.last_name, users.third_name, users.result_score, users.enrolled FROM users WHERE users.specialty_num = ? " +
            "AND users.status_num = 0 AND users.role_num = 1";
    public final static String SQL_FIND_ROLE = "SELECT users.role_num FROM users WHERE users.login LIKE ?";
    public final static String SQL_FIND_STATUS = "SELECT users.status_num FROM users WHERE users.login LIKE ?";
    public final static String SQL_UPDATE_LOGIN = "UPDATE users SET users.login = ? WHERE users.login LIKE ?";
    public final static String SQL_UPDATE_PASSWORD = "UPDATE users SET users.password = ? WHERE users.login LIKE ?";
    public final static String SQL_UPDATE_ROLE_NUM = "UPDATE users SET users.role_num = ? WHERE users.login LIKE ?";
    public final static String SQL_UPDATE_STATUS_NUM = "UPDATE users SET users.status_num = ? WHERE users.login LIKE ?";
    public final static String SQL_UPDATE_FIRST_NAME = "UPDATE users SET users.first_name = ? WHERE users.login LIKE ?";
    public final static String SQL_UPDATE_LAST_NAME = "UPDATE users SET users.last_name = ? WHERE users.login LIKE ?";
    public final static String SQL_UPDATE_THIRD_NAME = "UPDATE users SET users.third_name = ? WHERE users.login LIKE ?";
    public final static String SQL_UPDATE_BIRTHDAY = "UPDATE users SET users.birthday = ? WHERE users.login LIKE ?";
    public final static String SQL_UPDATE_COUNTRY = "UPDATE users SET users.country = ? WHERE users.login LIKE ?";
    public final static String SQL_UPDATE_LOCALITY = "UPDATE users SET users.locality = ? WHERE users.login LIKE ?";
    public final static String SQL_UPDATE_ADDRESS = "UPDATE users SET users.address = ? WHERE users.login LIKE ?";
    public final static String SQL_UPDATE_PHONE = "UPDATE users SET users.phone = ? WHERE users.login LIKE ?";
    public final static String SQL_UPDATE_EMAIL = "UPDATE users SET users.email = ? WHERE users.login LIKE ?";
    public final static String SQL_UPDATE_SPECIALTY_NUM = "UPDATE users SET users.specialty_num = ? WHERE users.login LIKE ?";
    public final static String SQL_UPDATE_GPA = "UPDATE users SET users.gpa = ? WHERE users.login LIKE ?";
    public final static String SQL_UPDATE_LANGUAGE_SCORE = "UPDATE users SET users.language_score = ? WHERE users.login LIKE ?";
    public final static String SQL_UPDATE_MATH_SCORE = "UPDATE users SET users.math_score = ? WHERE users.login LIKE ?";
    public final static String SQL_UPDATE_THIRD_SCORE = "UPDATE users SET users.third_score = ? WHERE users.login LIKE ?";
    public final static String SQL_UPDATE_RESULT_SCORE = "UPDATE users SET users.result_score = ? WHERE users.login LIKE ?";
    public final static String SQL_UPDATE_ENROLLED = "UPDATE users SET users.enrolled = ? WHERE users.login LIKE ?";
    public final static String SQL_FIND_ALL_SPECIALTIES = "SELECT specialties.specialty_num, specialties.name, " +
            "specialties.plan, faculties.name FROM specialties JOIN faculties ON specialties.faculty_num = faculties.faculty_num";

}
