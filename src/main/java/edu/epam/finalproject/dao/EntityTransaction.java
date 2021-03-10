package edu.epam.finalproject.dao;

import edu.epam.finalproject.connection.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class EntityTransaction {
    Logger logger = LogManager.getLogger(EntityTransaction.class);
    private Connection connection;

    public void begin(AbstractDao dao, AbstractDao... daos) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        if (connection == null){
            connection = connectionPool.getConnection();
        }
        try{
            connection.setAutoCommit(false);
        }catch (SQLException e){
            logger.error(e);
        }
        dao.setConnection(connection);
        for(AbstractDao daoElement  : daos){
            daoElement.setConnection(connection);
        }
    }

    public void end(){
        try{
            connection.setAutoCommit(true);
        }catch (SQLException e){
            logger.error(e);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error(e);
        }
        connection = null;
    }

    public void commit(){
        try{
            connection.commit();
        }catch (SQLException e){
            logger.error(e);
        }
    }

    public void rollback(){
        try{
            connection.rollback();
        }catch (SQLException e){
            logger.error(e);
        }
    }
}
