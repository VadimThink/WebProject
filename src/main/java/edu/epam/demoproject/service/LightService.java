package edu.epam.demoproject.service;

import edu.epam.demoproject.entity.Light;

public class LightService {

    public void turnOn(Light light){
        light.setOn(true);
    }

    public void turnOff(Light light){
        light.setOn(false);
    }


}
