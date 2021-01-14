package edu.epam.demoproject.entity;

public class User extends Entity {

    private long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private int statusNum;
    private int facultyNum;
    private int specialtyNum;

    public User(long id, String login, String password, String firstName, String lastName, int statusNum, int facultyNum, int specialtyNum) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.statusNum = statusNum;
        this.facultyNum = facultyNum;
        this.specialtyNum = specialtyNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setStatusNum(int status_num) {
        this.statusNum = status_num;
    }

    public int getFacultyNum() {
        return facultyNum;
    }

    public void setFacultyNum(int faculty_num) {
        this.facultyNum = faculty_num;
    }

    public int getSpecialtyNum() {
        return specialtyNum;
    }

    public void setSpecialtyNum(int specialty_num) {
        this.specialtyNum = specialty_num;
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
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
