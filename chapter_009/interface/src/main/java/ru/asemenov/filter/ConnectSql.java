package ru.asemenov.filter;

import org.apache.commons.dbcp2.BasicDataSource;
import ru.asemenov.filter.models.Role;
import ru.asemenov.filter.models.User;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * Class ConnectSql решение задачи части 009.
 * @author asemenov
 * @version 1
 */
public class ConnectSql {

    private static final ConnectSql instance = new ConnectSql();

    private ConnectSql() {
        setDataSoure();
    }

    public static ConnectSql getInstance() {
        return instance;
    }

    private BasicDataSource ds;

    /**
     * Connection.
     */
    private void setDataSoure() {
        Properties props = new Properties();
        InputStream fis;
        this.ds = new BasicDataSource();
        ClassLoader loader = getClass().getClassLoader();
        try {
            fis = loader.getResourceAsStream("db.properties");
            props.load(fis);
        }catch(IOException e){
            e.printStackTrace();
        }
        this.ds.setDriverClassName(props.getProperty("DRIVER"));
        this.ds.setUrl(props.getProperty("URL"));
        this.ds.setUsername(props.getProperty("USERNAME"));
        this.ds.setPassword(props.getProperty("PASSWORD"));
    }

    /**
     * Add users.
     * @param name String.
     * @param login String.
     * @param email String.
     */
    public void addUser(String name, String login, String password,  String email, int role_id) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = this.ds.getConnection();
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
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
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
    public void editUser(String oldLogin, String name, String login, String email) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = this.ds.getConnection();
            ps = connection.prepareStatement("UPDATE sec_users SET name = ?, login = ?, email = ? WHERE login = ?");
            ps.setString(1, name);
            ps.setString(2, login);
            ps.setString(3, email);
            ps.setString(4, oldLogin);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
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
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = this.ds.getConnection();
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
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
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
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = this.ds.getConnection();
            ps = connection.prepareStatement("DELETE FROM sec_users WHERE login = ?");
            ps.setString(1, login);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean checkPassword(String login, String password) {
        boolean result = false;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = this.ds.getConnection();
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
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public User getUser(String login) {
        User user = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = this.ds.getConnection();
            ps = connection.prepareStatement("SELECT u.id, u.name, u.login, u.password, u.email, u.role_id, r.name role_name from sec_users u LEFT JOIN roles r on u.role_id = r.id WHERE u.login = ?");
            ps.setString(1, login);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("email"),
                        new Role(rs.getInt("role_id"), rs.getString("role_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public List<Role> getRoles() {
        List<Role> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = this.ds.getConnection();
            ps = connection.prepareStatement("SELECT * from roles");
            rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Role(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void setRole(String login, int role_id) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = this.ds.getConnection();
            ps = connection.prepareStatement("UPDATE sec_users SET role_id = ? WHERE login = ?");
            ps.setInt(1, role_id);
            ps.setString(2, login);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
