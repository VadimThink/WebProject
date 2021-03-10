package edu.epam.finalproject.entity;


import edu.epam.finalproject.command.impl.general.ProfileCommand;
import edu.epam.finalproject.service.CommandService;
import edu.epam.finalproject.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SpecialtyList extends Entity {
    private static final Logger logger = LogManager.getLogger(ProfileCommand.class);
    private static final String ERROR_FIND_SPECIALTY_LIST = "List of specialties was not received";

    private static SpecialtyList instance;
    private List<Specialty> specialtyList;

    private SpecialtyList(){
        CommandService service = new CommandService();
        try {
            specialtyList = service.findSpecialtyList();
        } catch (ServiceException e) {
            logger.error(ERROR_FIND_SPECIALTY_LIST, e);
            throw new RuntimeException(e);
        }
    }

    public static final SpecialtyList getInstance() {
        if (instance == null) {
            instance = new SpecialtyList();
        }
        return instance;
    }

    public List<Specialty> getSpecialtyList() {
        List<Specialty> list = new ArrayList<>(specialtyList);
        return list;
    }


}
