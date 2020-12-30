package edu.epam.demoproject.dao.impl;

import edu.epam.demoproject.dao.DaoException;
import edu.epam.demoproject.dao.UserDao;
import edu.epam.demoproject.entity.User;
import edu.epam.demoproject.entity.UserList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final Logger log = LogManager.getLogger(UserDaoImpl.class);

    @Override
    public void addUserToList(User user, UserList list) throws DaoException {
        if (list.getUsers().contains(user)) {
            throw new DaoException("This user is already in list: " + user);
        }
        list.addUser(user);
    }

    @Override
    public void addSeveralUsersToList(UserList userList, ArrayList<User> list){
        for(int i = 0; i < list.size(); i++){
            userList.addUser(list.get(i));
        }
    }

    @Override
    public List<User> findAllUsers(UserList list) {
        List<User> allUsers = list.getUsers();
        return allUsers;
    }

    @Override
    public User findUserByIndex(int index, UserList list){
        User user = list.getUserByIndex(index);
        return user;
    }

    @Override
    public void deleteUserFromList(User user, UserList list) {
        if (!list.getUsers().contains(user)) {
            log.throwing(new DaoException());
        }
        list.removeUser(user);
    }

    @Override
    public User updateUserId(User user, int otherId) {
        user.setId(otherId);
        return user;
    }

    public boolean checkUserByLoginAndPassword(UserList list, String login, String password){
        boolean result = false;
        for (int i = 0; i < list.size(); i++){
            User currentUser = list.getUserByIndex(i);
            if(currentUser.getLogin().equals(login) && currentUser.getPassword().equals(password)){
                result = true;
            }
        }
        return result;
    }

}
