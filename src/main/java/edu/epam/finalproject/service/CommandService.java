package edu.epam.finalproject.service;

import edu.epam.finalproject.dao.DaoException;
import edu.epam.finalproject.dao.EntityTransaction;
import edu.epam.finalproject.dao.impl.CommandDaoImpl;
import edu.epam.finalproject.entity.Specialty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CommandService {
    private static final Logger logger = LogManager.getLogger(CommandService.class);
    private static final String DATABASE_ERROR = "Can`t get access to Database";

    public List<Specialty> findSpecialtyList() throws ServiceException {
        EntityTransaction entityTransaction = new EntityTransaction();
        CommandDaoImpl specialtyDaoImpl = new CommandDaoImpl();
        entityTransaction.begin(specialtyDaoImpl);
        List<Specialty> specialtyList;
        try {
            specialtyList = specialtyDaoImpl.findSpecialtyList();
            entityTransaction.commit();
        } catch (DaoException e) {
            logger.error(DATABASE_ERROR, e);
            entityTransaction.rollback();
            throw new ServiceException(e);
        }
        entityTransaction.end();
        return specialtyList;
    }

}
