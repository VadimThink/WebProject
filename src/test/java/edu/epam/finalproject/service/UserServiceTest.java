package edu.epam.finalproject.service;

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
}