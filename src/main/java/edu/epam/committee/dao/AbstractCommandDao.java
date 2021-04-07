package edu.epam.committee.dao;

import edu.epam.committee.entity.Specialty;

import java.util.List;

public abstract class AbstractCommandDao extends AbstractDao {

    public abstract List<Specialty> findSpecialtyList() throws DaoException;

}
