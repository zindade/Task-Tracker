package com.taskcli.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class ConnectionManager {

    private static final String URL;
    private static final String USER;
    private static final String PASS;

    static {
        try (InputStream in = ConnectionManager.class
                .getClassLoader()
                .getResourceAsStream("db.properties")) {

            Properties p = new Properties();
            p.load(in);

            URL  = System.getenv().getOrDefault("DB_URL",  p.getProperty("db.url"));
            USER = System.getenv().getOrDefault("DB_USER", p.getProperty("db.user"));
            PASS = System.getenv().getOrDefault("DB_PASS", p.getProperty("db.password"));

            String driver = p.getProperty("db.driver");
            if (driver != null && !driver.isBlank()) {
                Class.forName(driver);
            }

        } catch (Exception e) {
            throw new IllegalStateException("Error loading database configuration (db.properties)", e);
        }
    }

    private ConnectionManager() {}

    public static Connection getConnection() throws java.sql.SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

