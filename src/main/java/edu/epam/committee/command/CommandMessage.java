package edu.epam.committee.command;

/**
 * The type Message.
 */
public class CommandMessage {

    /**
     * The constant WRONG_AUTH.
     */
    public static final String WRONG_AUTH = "wrongAuth";
    /**
     * The constant DIFFERENT_PASSWORDS.
     */
    public static final String DIFFERENT_PASSWORDS = "differentPasswords";
    /**
     * The constant THIS_USER_IS_EXIST.
     */
    public static final String THIS_USER_IS_EXIST = "existUser";
    /**
     * The constant CANT_FIND_USER.
     */
    public static final String DATABASE_ERROR = "databaseError";
    /**
     * The constant USER_BLOCKED.
     */
    public static final String USER_BLOCKED = "userBlocked";
    /**
     * The constant CANT_FIND_USERS_IN_THIS_RANGE.
     */
    public static final String CANT_FIND_USERS_IN_THIS_RANGE = "cantFindUsersInRange";
    /**
     * The constant VALIDATION_ERROR.
     */
    public static final String VALIDATION_ERROR = "validationError";

    private CommandMessage() {
    }
}
