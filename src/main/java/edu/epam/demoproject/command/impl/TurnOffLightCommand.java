package edu.epam.demoproject.command.impl;

import edu.epam.demoproject.command.Command;
import edu.epam.demoproject.entity.Light;
import edu.epam.demoproject.service.LightService;

public class TurnOffLightCommand implements Command {

    private Light light;
    private LightService lightService = new LightService();

    public TurnOffLightCommand(Light light){
        this.light = light;
    }

    public void execute(){
        lightService.turnOff(light);
    }
}
