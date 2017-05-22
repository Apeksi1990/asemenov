package ru.asemenov.jsoup;

import java.sql.*;
/**
 * Class ConnectSql решение задачи части 008.
 * @author asemenov
 * @version 1
 */
public class ConnectSql {
    /**
     * URL.
     */
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    /**
     * Login.
     */
    static final String USER = "postgres";
    /**
     * Password.
     */
    static final String PASS = "password";

    /**
     * Connection.
     * @return connection.
     */
    public Connection connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * Add job.
     * @param head string.
     * @param linkHref string.
     * @param author string.
     * @param time timestamp.
     */
    public void addJob(String head, String linkHref, String author, Timestamp time) {
        PreparedStatement ps = null;
        try {
            ps = connection().prepareStatement("INSERT INTO job(head, link, author, create_date) VALUES (?,?,?,?)");
            ps.setString(1, head);
            ps.setString(2, linkHref);
            ps.setString(3, author);
            ps.setTimestamp(4, time);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                    connection().close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
