package edu.epam.committee.logic.validator;

import edu.epam.committee.entity.SpecialtyList;

/**
 * The type Input validator.
 */
public class InputValidator {
    /**
     * The constant SCORE_MIN_SIZE.
     */
    final static int SCORE_MIN_SIZE = 0;
    /**
     * The constant SCORE_MAX_SIZE.
     */
    final static int SCORE_MAX_SIZE = 100;
    /**
     * The constant NAME_MAX_LENGTH.
     */
    final static int NAME_MAX_LENGTH = 20;
    /**
     * The constant OTHER_FIELDS_MAX_LENGTH.
     */
    final static int OTHER_FIELDS_MAX_LENGTH = 50;

    final static String LOGIN_AND_PASSWORD_PATTERN = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";

    /**
     * Validate form boolean.
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
     */
    public static boolean validateForm(String login, String firstName, String lastName, String thirdName,
                                       String birthday, String country, String locality, String address, String phone,
                                       String email, int specialtyNum, int gpa, int languageScore, int mathScore,
                                       int thirdScore) {

        if (login == null || firstName == null || lastName == null || thirdName == null || birthday == null ||
                country == null || locality == null || address == null || phone == null || email == null) {
            return false;
        }
        if ((specialtyNum < 0 || specialtyNum > SpecialtyList.getInstance().size()) ||
                (gpa < SCORE_MIN_SIZE || gpa > SCORE_MAX_SIZE) ||
                (languageScore < SCORE_MIN_SIZE || languageScore > SCORE_MAX_SIZE) ||
                (mathScore < SCORE_MIN_SIZE || mathScore > SCORE_MAX_SIZE) ||
                (thirdScore < SCORE_MIN_SIZE || thirdScore > SCORE_MAX_SIZE)) {
            return false;
        }
        if (checkXSS(login) || checkXSS(firstName) || checkXSS(lastName) || checkXSS(thirdName) || checkXSS(birthday) ||
         checkXSS(country) || checkXSS(locality) || checkXSS(address) || checkXSS(phone) || checkXSS(email)){
            return false;
        }
        if ((login.length() > NAME_MAX_LENGTH) || (firstName.length() > NAME_MAX_LENGTH) ||
                (lastName.length() > NAME_MAX_LENGTH) || (thirdName.length() > NAME_MAX_LENGTH) ||
                (country.length() > OTHER_FIELDS_MAX_LENGTH) || (locality.length() > OTHER_FIELDS_MAX_LENGTH) ||
                (address.length() > OTHER_FIELDS_MAX_LENGTH) || (phone.length() > OTHER_FIELDS_MAX_LENGTH) ||
                (email.length() > OTHER_FIELDS_MAX_LENGTH)) {
            return false;
        }
        return true;
    }

    /**
     * Validate sign in and sign up boolean.
     *
     * @param login    the login
     * @param password the password
     * @return the boolean
     */
    public static boolean validateAuth(String login, String password) {
        if (login == null || password == null) {
            return false;
        }
        if (!login.matches(LOGIN_AND_PASSWORD_PATTERN) || !password.matches(LOGIN_AND_PASSWORD_PATTERN)){
            return false;
        }
        if(checkXSS(login) || checkXSS(password)){
            return false;
        }
        if (login.length() > NAME_MAX_LENGTH || password.length() > NAME_MAX_LENGTH) {
            return false;
        }
        return true;
    }

    private static boolean checkXSS(String parameter){
        boolean isValid = false;
        for (int i = 0; i < parameter.length(); i++){
            char curChar = parameter.charAt(i);
            if ((curChar == '<') || (curChar == '>') || (curChar == '\\') || (curChar == '\'')){
                isValid = true;
                break;
            }
        }
        return isValid;
    }

}
