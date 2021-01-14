package edu.epam.demoproject.connection;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlDataSourceFactory {
    public static MysqlDataSource createMysqlDataSource(){
        MysqlDataSource dataSource = null;
        String url = "jdbc:mysql://localhost:3306/web_project";
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "5636");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
        dataSource = new MysqlDataSource();
        dataSource.setURL(url);
        dataSource.setUser(prop.getProperty("user"));
        dataSource.setPassword(prop.getProperty("password"));
        return dataSource;
    }
    public static Connection getConnection() {
        Connection connection = null;
        try{
            connection = createMysqlDataSource().getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
