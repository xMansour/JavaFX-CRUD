package com.mansourappdevelopment.jdbcjavafxcrud.models;

import java.sql.*;

public class Database {
    private static final String url = "jdbc:mysql://localhost:3306/javafx";
    private static final String user = "jdbc";
    private static final String password = "jdbc";
    private Connection connection = null;

    private Connection createConnection() throws SQLException {
        if (connection == null)
            connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

}
