package edu.epam.demoproject.util;

import edu.epam.demoproject.entity.UserList;

public class IdGenerator {

    private static IdGenerator instance;
    private static int id = 0;

    private IdGenerator() {
    }

    public static final IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }

    public int getId() {
        return id++;
    }
}
