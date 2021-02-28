package edu.epam.finalproject.entity;

import edu.epam.finalproject.constant.RoleType;
import edu.epam.finalproject.constant.StatusType;

public class User extends Entity {

    private long id;
    private String login;
    private String firstName;
    private String lastName;
    private StatusType status;
    private int specialtyNum;
    private RoleType role;

    public User(long id, String login, StatusType status, RoleType role) {
        this.id = id;
        this.login = login;
        this.status = status;
        this.role = role;
        this.specialtyNum = 0;
    }

    public User(String login, StatusType status, RoleType role) {
        this.login = login;
        this.status = status;
        this.role = role;
        this.specialtyNum = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public boolean isBlocked(){
        return status == StatusType.BLOCKED;
    }

    public boolean isUnactive(){ return status == StatusType.UNACTIVE;}

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public boolean isUserRole(){
        return role == RoleType.USER;
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
        return specialtyNum == user.specialtyNum &&
                login.equals(user.login) &&
                firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                status == user.status &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + specialtyNum ^ (specialtyNum >>> 32);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("login='").append(login).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", status=").append(status);
        sb.append(", specialtyNum=").append(specialtyNum);
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }
}
