package edu.epam.demoproject.dao;

import edu.epam.demoproject.connection.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class EntityTransaction {
    private Connection connection;

    public void begin(AbstractDao dao, AbstractDao... daos) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        if (connection == null){
            connection = connectionPool.getConnection();
        }
        try{
            connection.setAutoCommit(false);
        }catch (SQLException e){
            e.printStackTrace();
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
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection = null;
    }

    public void commit(){
        try{
            connection.commit();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void rollback(){
        try{
            connection.rollback();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
