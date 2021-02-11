package edu.epam.finalproject.constant;

public enum StatusType {

    ACTIVE(1),
    UNACTIVE(2),//todo сделать через ordinal
    BLOCKED(3);

    private final int number;

    StatusType(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
