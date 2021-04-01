package edu.epam.finalproject.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ConnectionPool {
    private static final Logger logger = LogManager.getLogger();
    private static final ConnectionPool instance = new ConnectionPool();

    private static final String DATABASE_PROPERTIES = "db.properties";
    private static final String DATABASE_URL = "url";
    private static final String DATABASE_DRIVER = "driver";
    private static final int DEFAULT_POOL_SIZE = 32;

    private final BlockingQueue<ProxyConnection> freeConnections;
    private final Queue<ProxyConnection> busyConnections;

    private ConnectionPool() {
        freeConnections = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
        busyConnections = new ArrayDeque<>();
        ClassLoader classLoader = this.getClass().getClassLoader();
        Properties properties = new Properties();

        try {
            properties.load(classLoader.getResourceAsStream(DATABASE_PROPERTIES));
            String sqlUrl = properties.getProperty(DATABASE_URL);
            String sqlDriver = properties.getProperty(DATABASE_DRIVER);
            Class.forName(sqlDriver);
            for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
                freeConnections.add(new ProxyConnection(DriverManager.getConnection(sqlUrl, properties)));
            }
        } catch (IOException | ClassNotFoundException | SQLException exp) {
            logger.fatal(exp);
            throw new RuntimeException("Connection pool is not initialize.", exp);
        }
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    public ProxyConnection getConnection() {
        ProxyConnection proxyConnection = null;
        try {
            proxyConnection = freeConnections.take();
            busyConnections.add(proxyConnection);
        } catch (InterruptedException exp) {
            logger.error("The connection is not received", exp);
        }
        return proxyConnection;
    }

    public void releaseConnection(Connection connection) {
        if (connection.getClass() == ProxyConnection.class
                && busyConnections.remove(connection)) {
            freeConnections.offer((ProxyConnection) connection);
        } else {
            logger.error("Invalid connection type passed");
        }
    }

    public void destroyPool() {
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                freeConnections.take().reallyClose();
            } catch (SQLException | InterruptedException exp) {
                logger.error("The pool was not destroyed", exp);
            }
        }
        deregisterDrivers();
    }

    private void deregisterDrivers() {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException exp) {
                logger.error("Error while deregister drivers", exp);
            }
        }
    }
}
