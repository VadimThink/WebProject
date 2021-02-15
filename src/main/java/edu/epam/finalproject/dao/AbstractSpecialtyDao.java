package edu.epam.finalproject.dao;

import edu.epam.finalproject.entity.Specialty;

import java.util.List;

public abstract class AbstractSpecialtyDao extends AbstractDao {
    public abstract List<Specialty> findSpecialtyList() throws DaoException;

}
