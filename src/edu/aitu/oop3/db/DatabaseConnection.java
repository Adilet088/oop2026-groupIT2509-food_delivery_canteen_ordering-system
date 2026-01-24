package edu.aitu.oop3.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static String DB_URL;
    private static String DB_USER;
    private static String DB_PASSWORD;

    static {
        try {
            Properties props = new Properties();

            InputStream is = DatabaseConnection.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (is == null) {
                throw new RuntimeException("config.properties not found on classpath");
            }

            props.load(is);

            DB_URL = props.getProperty("DB_URL");
            DB_USER = props.getProperty("DB_USER");
            DB_PASSWORD = props.getProperty("DB_PASSWORD");

        } catch (Exception e) {
            throw new RuntimeException("Failed to load database configuration", e);
        }
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
