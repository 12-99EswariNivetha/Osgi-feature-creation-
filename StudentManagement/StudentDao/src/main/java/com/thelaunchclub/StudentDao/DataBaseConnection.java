package com.thelaunchclub.StudentDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DataBase Connection.
 * 
 * @author EswariNivethaVU
 */
public class DataBaseConnection {

    /**
     * Connects the Database.
     */
    Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/studentdetails", "postgres",
                    "root");
        } catch (Exception e) {
            System.out.println("Connection Error");
        }
        return connection;
    }
}