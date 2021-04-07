package edu.epam.committee.logic.service;

import edu.epam.committee.entity.RoleType;
import edu.epam.committee.entity.Specialty;
import edu.epam.committee.entity.StatusType;
import edu.epam.committee.entity.User;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UserServiceTest {

    @Test
    public void testEnrollUsersByCompetition() {
        UserService userService = new UserService();
        boolean actual = false;
        try {
            actual = userService.enrollUsersByCompetition();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        assertTrue(actual);
    }

    @Test
    public void testCreateNewUser() {
        String login = "test";
        String password = "password";
        UserService userService = new UserService();
        boolean actual = false;
        try {
            actual = userService.createNewUser(login, password);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        assertTrue(actual);
    }

    @Test
    public void testCheckUserByLoginAndPassword() {
        String login = "test";
        String password = "password";
        UserService userService = new UserService();
        boolean actual = false;
        try {
            actual = userService.checkUserByLoginAndPassword(login, password);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        assertTrue(actual);
    }

    @Test
    public void testCheckAdminRole() {
        String login = "test";
        UserService userService = new UserService();
        boolean actual = false;
        try {
            actual = userService.checkAdminRole(login);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        assertFalse(actual);
    }

    @Test
    public void testUpdateUserFormData() {
        String login = "test";
        String firstName = "firstName";
        String lastName = "lastName";
        String thirdName = "thirdName";
        String birthday = "2021-01-01";
        String country = "country";
        String locality = "locality";
        String address = "address";
        String phone = "phone";
        String email = "email";
        int specialtyNum = 1;
        int gpa = 1;
        int languageScore = 1;
        int mathScore = 1;
        int thirdScore = 1;
        UserService userService = new UserService();
        boolean actual = false;
        try {
            actual = userService.updateUserFormData(login, firstName, lastName, thirdName, birthday, country, locality,
                    address, phone, email, specialtyNum, gpa, languageScore, mathScore, thirdScore );
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        assertTrue(actual);
    }

    @Test
    public void testUpdateUserEnrolled() {
        String login = "test";
        UserService userService = new UserService();
        boolean actual = false;
        try {
            actual = userService.updateUserEnrolled(login, false);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        assertFalse(actual);
    }

    @Test
    public void testFindNumberOfUsers() {
        UserService userService = new UserService();
        long actual = 0;
        try {
            actual = userService.findNumberOfUsers();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        boolean condition = false;
        if (actual > 0){
            condition = true;
        }
        assertTrue(condition);
    }

    @Test
    public void testFindUserInfo() {
        String login = "test";
        String firstName = "firstName";
        String lastName = "lastName";
        String thirdName = "thirdName";
        String birthday = "2021-01-01";
        String country = "country";
        String locality = "locality";
        String address = "address";
        String phone = "phone";
        String email = "email";
        Specialty specialty = new Specialty(1, "ПОИТ", 4, "ФКСИС");
        int gpa = 1;
        int languageScore = 1;
        int mathScore = 1;
        int thirdScore = 1;
        int resultScore = 4;
        int enrolled = 0;
        User user = new User(specialty, firstName, lastName, thirdName, birthday, country, locality, address, phone, email,
                 gpa, languageScore, mathScore, thirdScore, resultScore, enrolled);
        UserService userService = new UserService();
        User actual = null;
        try {
            actual = userService.findUserInfo(login);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        assertEquals(user, actual);
    }

    @Test
    public void testUpdateUserStatus() {
        String login = "test";
        UserService userService = new UserService();
        boolean actual = false;
        try {
            actual = userService.updateUserStatus(login, StatusType.BLOCKED);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        assertTrue(actual);
    }

    @Test
    public void testUpdateUserRole() {
        String login = "test";
        UserService userService = new UserService();
        boolean actual = false;
        try {
            actual = userService.updateUserRole(login, RoleType.USER);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        assertTrue(actual);
    }

    @Test
    public void testIsUserNotBlocked() {
        String login = "test";
        UserService userService = new UserService();
        boolean actual = false;
        try {
            actual = userService.isUserNotBlocked(login);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        assertFalse(actual);
    }
}