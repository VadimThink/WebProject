package edu.epam.demoproject.dao;

import edu.epam.demoproject.entity.User;
import edu.epam.demoproject.entity.UserList;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {

    void addUserToList(User user, UserList userList) throws DaoException;

    void addSeveralUsersToList(UserList userList, ArrayList<User> list);

    void deleteUserFromList(User user, UserList shop);

    List<User> findAllUsers(UserList userList);

    User findUserByIndex(int index, UserList userList);

    User updateUserId(User user, int otherId);

    public boolean checkUserByLoginAndPassword(UserList list, String login, String password);

}