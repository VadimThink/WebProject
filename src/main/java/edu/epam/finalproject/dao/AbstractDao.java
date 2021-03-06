package edu.epam.finalproject.dao;

import edu.epam.finalproject.entity.Entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDao<K, T extends Entity> {
    protected Connection connection;

    public abstract List<T> findAll() throws DaoException;
    public abstract void create(T t) throws DaoException;
    public abstract T update(T t) throws DaoException;

    public void close(Statement statement){
        try{
            if(statement != null){
                statement.close();
            }
        }catch (SQLException e){
            //log
        }
    }

    public void close(Connection connection){
        try{
            if(connection != null){
                connection.close();
            }
        }catch (SQLException e){
            //log
        }
    }

    public void setConnection(Connection connection){
        this.connection = connection;
    }

}
