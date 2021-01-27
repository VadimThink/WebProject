package edu.epam.demoproject.connection;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MysqlDataSourceFactory {

    static {
        try{
            ClassLoader classLoader = MysqlDataSource.class.getClassLoader();
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static MysqlDataSource createBasicDataSource(){
        MysqlDataSource dataSource = new MysqlDataSource();
        String url = "jdbc:mysql://localhost:3306/web_project";
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "5636");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
        dataSource.setURL(url);
        dataSource.setUser(prop.getProperty("user"));
        dataSource.setPassword(prop.getProperty("password"));
        return dataSource;
    }
    public static Connection getConnection() {
        Connection connection = null;
        try{
            connection = createBasicDataSource().getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
