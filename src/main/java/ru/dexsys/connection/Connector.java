package ru.dexsys.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "1993909";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgresdb";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }
}
