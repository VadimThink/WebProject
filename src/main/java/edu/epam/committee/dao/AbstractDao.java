package edu.epam.committee.dao;

import edu.epam.committee.entity.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDao<T extends Entity> {
    private static final Logger logger = LogManager.getLogger(AbstractDao.class);
    protected Connection connection;

    public abstract List<T> findAll() throws DaoException;

    public void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    public void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
