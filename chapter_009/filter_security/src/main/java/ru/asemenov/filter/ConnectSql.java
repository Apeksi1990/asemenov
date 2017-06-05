package ru.asemenov.filter;

import ru.asemenov.filter.models.Role;
import ru.asemenov.filter.models.User;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class ConnectSql решение задачи части 009.
 * @author asemenov
 * @version 1
 */
public class ConnectSql {

    private static final ConnectSql instance = new ConnectSql();

    private ConnectSql() {
    }

    public static ConnectSql getInstance() {
        return instance;
    }

    /**
     * Connection.
     */
    private Connection connection() {
        Connection conn = null;
        InitialContext initContext;
        try {
            initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
            conn = ds.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * Add users.
     * @param name String.
     * @param login String.
     * @param email String.
     */
    public void addUser(String name, String login, String password,  String email, int role_id) {
        Connection connection = connection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO sec_users(name, login, password, email, create_date, role_id) VALUES (?,?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, login);
            ps.setString(3, password);
            ps.setString(4, email);
            ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            ps.setInt(6, role_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Edit user.
     * @param name String.
     * @param login String.
     * @param email String.
     */
    public void editUser(String name, String login, String email) {
        Connection connection = connection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE sec_users SET name = ?, login = ?, email = ? WHERE login = ?");
            ps.setString(1, name);
            ps.setString(2, login);
            ps.setString(3, email);
            ps.setString(4, login);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                if (ps != null) {
                    ps.close();
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
    public List<User> getUser() {
        Connection connection = connection();
        List<User> users = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT u.id, u.name, u.login, u.password, u.email, u.role_id, r.name role_name from sec_users u LEFT JOIN roles r on u.role_id = r.id");
            rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("email"),
                        new Role(rs.getInt("role_id"), rs.getString("role_name"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    /**
     * Delete user.
     * @param login String.
     */
    public void deleteUser(String login) {
        Connection connection = connection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("DELETE FROM sec_users WHERE login = ?");
            ps.setString(1, login);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean checkPassword(String login, String password) {
        Connection connection = connection();
        boolean result = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT password from sec_users where login = ?");
            ps.setString(1, login);
            rs = ps.executeQuery();
            rs.next();
            if (rs.getString("password").equals(password)) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public String getRole(String login) {
        Connection connection = connection();
        String result = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT r.name role_name from sec_users u LEFT JOIN roles r on u.role_id = r.id where login = ?");
            ps.setString(1, login);
            rs = ps.executeQuery();
            rs.next();
            result = rs.getString("role_name");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public Map<Integer, String> getRoles() {
        Connection connection = connection();
        Map<Integer, String> result = new HashMap<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT * from roles");
            rs = ps.executeQuery();
            while (rs.next()) {
                result.put(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void setRole(String login, int role_id) {
        Connection connection = connection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE sec_users SET role_id = ? WHERE login = ?");
            ps.setInt(1, role_id);
            ps.setString(2, login);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
