package edu.epam.finalproject.constant;

public enum RoleType {

    ADMIN(1),
    USER(2);

    private final int number;

    RoleType(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
