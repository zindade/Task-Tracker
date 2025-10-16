package main.java.com.taskcli.infra;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private  static String URL = System.getenv("DB_URL");
    private  static final String USER = System.getenv("DB_USER");
    private static final String Pass = System.getenv("DB_PASSWORD");



            try{
        Connection connection = DriverManager.getConnection(URL,USER, Pass);
        System.out.println("connection to the database established");
        connection.close();
    }catch(SQLException e) {
        System.out.println("error connecting to the database" +e.getMessage());
    }
}
