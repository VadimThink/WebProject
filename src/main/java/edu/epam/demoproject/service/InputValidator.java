package edu.epam.demoproject.service;

public class InputValidator {

    public boolean checkStringLightCondition(String lightCondition){
        return lightCondition.toLowerCase().equals("включен") || lightCondition.toLowerCase().equals("выключен");
    }
}
