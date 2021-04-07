package edu.epam.committee.entity;

public class Specialty {

    private int specialtyNum;
    private String specialtyName;
    private int plan;
    private String faculty;

    public Specialty(int specialtyNum, String specialtyName, int plan, String faculty) {
        this.specialtyNum = specialtyNum;
        this.specialtyName = specialtyName;
        this.plan = plan;
        this.faculty = faculty;
    }

    public int getSpecialtyNum() {
        return specialtyNum;
    }

    public void setSpecialtyNum(int specialtyNum) {
        this.specialtyNum = specialtyNum;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialty specialty = (Specialty) o;

        if (specialtyNum != specialty.specialtyNum) return false;
        if (plan != specialty.plan) return false;
        if (specialtyName != null ? !specialtyName.equals(specialty.specialtyName) : specialty.specialtyName != null)
            return false;
        return faculty != null ? faculty.equals(specialty.faculty) : specialty.faculty == null;
    }

    @Override
    public int hashCode() {
        int result = specialtyNum;
        result = 31 * result + (specialtyName != null ? specialtyName.hashCode() : 0);
        result = 31 * result + plan;
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Specialty{");
        sb.append("specialtyNum=").append(specialtyNum);
        sb.append(", specialtyName='").append(specialtyName).append('\'');
        sb.append(", plan=").append(plan);
        sb.append(", faculty='").append(faculty).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
