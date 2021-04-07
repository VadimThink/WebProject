package edu.epam.committee.logic.service;

import edu.epam.committee.dao.DaoException;
import edu.epam.committee.dao.EntityTransaction;
import edu.epam.committee.dao.impl.CommandDaoImpl;
import edu.epam.committee.entity.Specialty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CommandService {
    private static final Logger logger = LogManager.getLogger(CommandService.class);
    private static final String DATABASE_ERROR = "Can`t get access to Database";

    /**
     * Find specialty list.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
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
