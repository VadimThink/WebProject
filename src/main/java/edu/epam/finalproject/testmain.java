package edu.epam.finalproject;

import edu.epam.finalproject.entity.User;
import edu.epam.finalproject.service.ServiceException;
import edu.epam.finalproject.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class testmain {

    public static void main(String[] args){
        UserService userService = new UserService();
        List<User> userList = new ArrayList<>();
        try {
            userList = userService.findAllUsers();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        System.out.println(userList.toString());
    }

}
