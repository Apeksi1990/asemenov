package ru.asemenov.jsoup;

import java.sql.*;

public class ConnectSql {

    //  Database credentials
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "password";

    public Connection connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
        return connection;
    }

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

    public Timestamp lastTime() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Timestamp time = null;
        try {
            ps = connection().prepareStatement("SELECT create_date FROM job ORDER BY create_date DESC Limit 1");
            rs = ps.executeQuery();
            while (rs.next()) {
                time =  rs.getTimestamp("create_date");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    rs.close();
                    ps.close();
                    connection().close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return time;
    }
}
