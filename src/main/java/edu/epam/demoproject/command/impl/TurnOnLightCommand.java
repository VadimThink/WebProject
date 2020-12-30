package edu.epam.demoproject.command.impl;

import edu.epam.demoproject.command.Command;
import edu.epam.demoproject.entity.Light;
import edu.epam.demoproject.service.LightService;

public class TurnOnLightCommand implements Command {

    private LightService lightService = new LightService();
    private Light light;

    public TurnOnLightCommand(Light light){
        this.light = light;
    }

    public void execute(){
        lightService.turnOn(light);
    }
}

