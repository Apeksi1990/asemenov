package ru.asemenov.UsersServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Class ConnectSql решение задачи части 009.
 * @author asemenov
 * @version 1
 */
public class ConnectSql {
    /**
     * URL.
     */
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    /**
     * Login.
     */
    private static final String USER = "postgres";
    /**
     * Password.
     */
    private static final String PASS = "password";

    /**
     * Connection.
     * @return connect.
     */
    private Connection connection() {
        Connection connection = null;
        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Add users.
     * @param name String.
     * @param login String.
     * @param email String.
     */
    public void addUser(String name, String login, String email) {
        PreparedStatement ps = null;
        try {
            ps = connection().prepareStatement("INSERT INTO users(name, login, email, create_date) VALUES (?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, login);
            ps.setString(3, email);
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection() != null) {
                    connection().close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Edit user.
     * @param id int.
     * @param name String.
     * @param login String.
     * @param email String.
     */
    public void editUser(int id, String name, String login, String email) {
        PreparedStatement ps = null;
        try {
            ps = connection().prepareStatement("UPDATE users SET name = ?, login = ?, email = ? WHERE id = ?");
            ps.setString(1, name);
            ps.setString(2, login);
            ps.setString(3, email);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection() != null) {
                    connection().close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Get user.
     * @return List.
     */
    public List<User> getUset() {
        List<User> users = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            ps = connection().prepareStatement("SELECT * from users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("login"), rs.getString("email"), rs.getTimestamp("create_date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection() != null) {
                    connection().close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    /**
     * Delete user.
     * @param id int.
     */
    public void deleteUser(int id) {
        PreparedStatement ps = null;
        try {
            ps = connection().prepareStatement("DELETE FROM users WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection() != null) {
                    connection().close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
