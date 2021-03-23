package edu.epam.finalproject.util;

import edu.epam.finalproject.entity.User;

import java.util.Comparator;

public class ScoreComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return Integer.compare(o1.getResultScore(), o2.getResultScore());
    }
}
