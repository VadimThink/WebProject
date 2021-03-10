package edu.epam.finalproject.util;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordEncrypt {
    private PasswordEncrypt() {
    }

    public static String encryptPassword(String password) {
        String encryptedPassword = DigestUtils.md5Hex(password);
        return encryptedPassword;
    }
}
