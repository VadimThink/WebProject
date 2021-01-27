package edu.epam.demoproject.dao;

import edu.epam.demoproject.entity.Entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDao<K, T extends Entity> {
    protected Connection connection;

    public abstract List<T> findAll();
    public abstract T findById(K id);
    public abstract boolean delete(T t);
    public abstract boolean delete(K id);
    public abstract void create(T t) throws SQLException;
    public abstract T update(T t);

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
