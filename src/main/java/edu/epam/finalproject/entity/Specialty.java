package edu.epam.finalproject.entity;

public class Specialty {

    private int specialtyNum;
    private String specialtyName;
    private int facultyNum;

    public Specialty(int specialtyNum, String specialtyName, int facultyNum) {
        this.specialtyNum = specialtyNum;
        this.specialtyName = specialtyName;
        this.facultyNum = facultyNum;
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

    public int getFacultyNum() {
        return facultyNum;
    }

    public void setFacultyNum(int facultyNum) {
        this.facultyNum = facultyNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialty specialty = (Specialty) o;
        return specialtyNum == specialty.specialtyNum &&
                facultyNum == specialty.facultyNum &&
                specialtyName.equals(specialty.specialtyName);
    }

    @Override
    public int hashCode() {
        int result = specialtyNum ^ (specialtyNum >>> 32);
        result = 31 * result + (specialtyName != null ? specialtyName.hashCode() : 0);
        result = 31 * result + facultyNum ^ (facultyNum >>> 32);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Specialty{");
        sb.append("specialtyNum=").append(specialtyNum);
        sb.append(", specialtyName='").append(specialtyName).append('\'');
        sb.append(", facultyNum=").append(facultyNum);
        sb.append('}');
        return sb.toString();
    }
}
