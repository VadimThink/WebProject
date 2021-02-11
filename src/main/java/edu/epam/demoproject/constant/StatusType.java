package edu.epam.demoproject.constant;

public enum StatusType {

    ACTIVE(1),
    UNACTIVE(2),
    BLOCKED(3);

    private final int number;

    StatusType(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
