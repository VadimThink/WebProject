package edu.epam.finalproject.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * The type Password encrypt.
 */
public class PasswordEncrypt {
    private PasswordEncrypt() {
    }

    /**
     * Encrypt password.
     *
     * @param password the password
     * @return the string
     */
    public static String encryptPassword(String password) {
        String encryptedPassword = DigestUtils.md5Hex(password);
        return encryptedPassword;
    }
}
