package com.mansourappdevelopment.jdbcjavafxcrud.models;

import java.sql.*;

public class Database {
    private static final String url = "jdbc:mysql://localhost:3306/javafx";
    private static final String user = "jdbc";
    private static final String password = "jdbc";
    private static Connection connection = null;

    private static Connection getConnection() throws SQLException {
        if (connection == null)
            connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
        return connection;
    }

    public static void create(Book book) throws SQLException {
        PreparedStatement insert = getConnection().prepareStatement("INSERT INTO BOOKS(title, author," +
                "year, pages)  VALUES(?,?,?,?)");
        insert.setString(1, book.getTitle());
        insert.setString(2, book.getAuthor());
        insert.setString(3, book.getYear());
        insert.setInt(4, book.getPages());

        insert.executeUpdate();
    }

    public static void update(Book book) throws SQLException {
        PreparedStatement update = getConnection().prepareStatement("UPDATE BOOKS SET title=?, author=?, year=?, pages=? where id=?");
        update.setString(1, book.getTitle());
        update.setString(2, book.getAuthor());
        update.setString(3, book.getYear());
        update.setInt(4, book.getPages());
        update.setInt(5, book.getId());

        update.executeUpdate();
    }

    public static ResultSet read() throws SQLException {
        Statement select = getConnection().createStatement();
        return select.executeQuery("SELECT * FROM books");
    }


    public static void delete(int id) throws SQLException {
        PreparedStatement delete = getConnection().prepareStatement("DELETE FROM BOOKS WHERE id = ?");
        delete.setInt(1, id);
        delete.executeUpdate();
    }

    public static void truncate() throws SQLException {
        PreparedStatement truncate = getConnection().prepareStatement("TRUNCATE TABLE books");
        truncate.executeUpdate();
    }

    public static void commit() throws SQLException {
        connection.commit();
    }

    public static void rollback() throws SQLException {
        connection.rollback();
    }


}
