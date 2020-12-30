package edu.epam.demoproject.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserList {

    private static UserList instance;
    private List<User> users;

    private UserList() {
        this.users = new ArrayList<>();
    }

    public static final UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    public List<User> getUsers(){
        List<User> userList = new ArrayList<>(users);
        return userList;
    }

    public User getUserByIndex(int index){
        List<User> userList = new ArrayList<>(users);
        return userList.get(index);
    }

    public void addUser(User newUser){
        users.add(newUser);
    }

    public void removeUser(User user){
        users.remove(user);
    }

    public int size(){
        return users.size();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserList{");
        sb.append("instance=").append(instance);
        sb.append(", users=").append(users);
        sb.append('}');
        return sb.toString();
    }

}
