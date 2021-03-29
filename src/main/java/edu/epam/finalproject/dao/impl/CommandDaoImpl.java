package edu.epam.finalproject.dao.impl;

import edu.epam.finalproject.dao.AbstractCommandDao;
import edu.epam.finalproject.dao.DaoException;
import edu.epam.finalproject.entity.Entity;
import edu.epam.finalproject.entity.Specialty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static edu.epam.finalproject.dao.SqlRequest.SQL_FIND_ALL_SPECIALTIES;

public class CommandDaoImpl extends AbstractCommandDao {

    @Override
    public List<Specialty> findSpecialtyList() throws DaoException {
        List<Specialty> specialtyList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL_SPECIALTIES);
            while (resultSet.next()) {
                int specialtyNum = resultSet.getInt(1);
                String specialtyName = resultSet.getString(2);
                int plan = resultSet.getInt(3);
                String faculty = resultSet.getString(4);
                Specialty specialty = new Specialty(specialtyNum, specialtyName, plan, faculty);
                specialtyList.add(specialty);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return specialtyList;
    }

    @Override
    public List findAll() throws DaoException {
        throw new UnsupportedOperationException();
    }


    @Override
    public void create(Entity entity) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Entity update(Entity entity) throws DaoException {
        throw new UnsupportedOperationException();
    }
}
