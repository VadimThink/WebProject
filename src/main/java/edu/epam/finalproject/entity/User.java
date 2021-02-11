package edu.epam.finalproject.entity;

public class User extends Entity {

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private int statusNum;
    private int specialtyNum;
    private int roleNum;

    public User(String login, String password, String firstName, String lastName, int statusNum, int specialtyNum, int roleNum) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.statusNum = statusNum;
        this.specialtyNum = specialtyNum;
        this.roleNum = roleNum;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStatusNum() {
        return statusNum;
    }

    public void setStatusNum(int statusNum) {
        this.statusNum = statusNum;
    }

    public int getRoleNum() {
        return roleNum;
    }

    public void setRoleNum(int faculty_num) {
        this.roleNum = roleNum;
    }

    public int getSpecialtyNum() {
        return specialtyNum;
    }

    public void setSpecialtyNum(int specialtyNum) {
        this.specialtyNum = specialtyNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
