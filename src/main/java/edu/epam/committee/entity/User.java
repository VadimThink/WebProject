package edu.epam.committee.entity;

public class User extends Entity {

    private long id;
    private StatusType status;
    private Specialty specialty;
    private RoleType role;
    private String login;
    private String firstName;
    private String lastName;
    private String thirdName;
    private String birthday;
    private String country;
    private String locality;
    private String address;
    private String phone;
    private String email;
    private int gpa;
    private int languageScore;
    private int mathScore;
    private int thirdScore;
    private int resultScore;
    private boolean isEnrolled;

    public User(long id, String login, StatusType status, RoleType role) {
        this.id = id;
        this.login = login;
        this.status = status;
        this.role = role;
    }

    public User(String login, StatusType status, RoleType role) {
        this.login = login;
        this.status = status;
        this.role = role;
    }

    public User(String login, String firstName, String lastName, String thirdName, int resultScore, int enrolled) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.thirdName = thirdName;
        this.resultScore = resultScore;
        this.isEnrolled = (enrolled == 1);
    }

    public User(Specialty specialty, String firstName, String lastName, String thirdName, String birthday, String country, String locality,
                String address, String phone, String email, int gpa, int languageScore, int mathScore, int thirdScore,
                int resultScore, int enrolled) {
        this.specialty = specialty;
        this.firstName = firstName;
        this.lastName = lastName;
        this.thirdName = thirdName;
        this.birthday = birthday;
        this.country = country;
        this.locality = locality;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.gpa = gpa;
        this.languageScore = languageScore;
        this.mathScore = mathScore;
        this.thirdScore = thirdScore;
        this.resultScore = resultScore;
        this.isEnrolled = (enrolled == 1);
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

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public boolean isBlocked() {
        return status == StatusType.BLOCKED;
    }

    public boolean isInactive() {
        return status == StatusType.INACTIVE;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public boolean isUserRole() {
        return role == RoleType.USER;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public int getLanguageScore() {
        return languageScore;
    }

    public void setLanguageScore(int languageScore) {
        this.languageScore = languageScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getThirdScore() {
        return thirdScore;
    }

    public void setThirdScore(int thirdScore) {
        this.thirdScore = thirdScore;
    }

    public int getResultScore() {
        return resultScore;
    }

    public void setResultScore(int resultScore) {
        this.resultScore = resultScore;
    }

    public boolean isEnrolled() {
        return isEnrolled;
    }

    public void setEnrolled(boolean enrolled) {
        isEnrolled = enrolled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (gpa != user.gpa) return false;
        if (languageScore != user.languageScore) return false;
        if (mathScore != user.mathScore) return false;
        if (thirdScore != user.thirdScore) return false;
        if (resultScore != user.resultScore) return false;
        if (isEnrolled != user.isEnrolled) return false;
        if (status != user.status) return false;
        if (specialty != null ? !specialty.equals(user.specialty) : user.specialty != null) return false;
        if (role != user.role) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (thirdName != null ? !thirdName.equals(user.thirdName) : user.thirdName != null) return false;
        if (birthday != null ? !birthday.equals(user.birthday) : user.birthday != null) return false;
        if (country != null ? !country.equals(user.country) : user.country != null) return false;
        if (locality != null ? !locality.equals(user.locality) : user.locality != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (specialty != null ? specialty.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (thirdName != null ? thirdName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (locality != null ? locality.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + gpa;
        result = 31 * result + languageScore;
        result = 31 * result + mathScore;
        result = 31 * result + thirdScore;
        result = 31 * result + resultScore;
        result = 31 * result + (isEnrolled ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", status=").append(status);
        sb.append(", specialty=").append(specialty);
        sb.append(", role=").append(role);
        sb.append(", login='").append(login).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", thirdName='").append(thirdName).append('\'');
        sb.append(", birthday='").append(birthday).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", locality='").append(locality).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", gpa=").append(gpa);
        sb.append(", languageScore=").append(languageScore);
        sb.append(", mathScore=").append(mathScore);
        sb.append(", thirdScore=").append(thirdScore);
        sb.append(", resultScore=").append(resultScore);
        sb.append(", isEnrolled=").append(isEnrolled);
        sb.append('}');
        return sb.toString();
    }
}
