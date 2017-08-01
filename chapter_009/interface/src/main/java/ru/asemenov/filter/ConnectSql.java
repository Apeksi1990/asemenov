package ru.asemenov.filter;

import org.apache.commons.dbcp2.BasicDataSource;
import ru.asemenov.filter.models.City;
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
    /**
     * Instance.
     */
    private static final ConnectSql instance = new ConnectSql();

    /**
     * Constructor.
     */
    private ConnectSql() {
        setDataSoure();
    }

    /**
     * Get instance.
     * @return instance.
     */
    public static ConnectSql getInstance() {
        return instance;
    }

    /**
     * Data source.
     */
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.ds.setDriverClassName(props.getProperty("DRIVER"));
        this.ds.setUrl(props.getProperty("URL"));
        this.ds.setUsername(props.getProperty("USERNAME"));
        this.ds.setPassword(props.getProperty("PASSWORD"));
    }

    /**
     * Add new user.
     * @param name string.
     * @param login string.
     * @param password string.
     * @param email string.
     * @param role_id int.
     * @param city_id int.
     */
    public void addUser(String name, String login, String password,  String email, int role_id, int city_id) {
        System.out.println("Перешел в коннект");
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = this.ds.getConnection();
            ps = connection.prepareStatement("INSERT INTO sec_users(name, login, password, email, create_date, role_id, city_id) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, login);
            ps.setString(3, password);
            ps.setString(4, email);
            ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            ps.setInt(6, role_id);
            ps.setInt(7, city_id);
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
     * @param oldLogin String.
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
            ps = connection.prepareStatement("SELECT u.id, u.name, u.login, u.password, u.email, u.role_id, r.name role_name, ci.name city, co.name country from sec_users u LEFT JOIN roles r on u.role_id = r.id LEFT JOIN cities ci on u.city_id = ci.id LEFT JOIN countries co on ci.country_id = co.id");
            rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("email"),
                        new Role(rs.getInt("role_id"), rs.getString("role_name")),
                        rs.getString("city"),
                        rs.getString("country")));
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

    /**
     * Check user password.
     * @param login string.
     * @param password string.
     * @return boolean.
     */
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

    /**
     * Get user.
     * @param login string.
     * @return User.
     */
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
                        new Role(rs.getInt("role_id"), rs.getString("role_name")),
                        null, null);
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

    /**
     * Get all roles.
     * @return List.
     */
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

    /**
     * Get all countries.
     * @return List.
     */
    public List<String> getCountries() {
        List<String> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = this.ds.getConnection();
            ps = connection.prepareStatement("SELECT * from countries");
            rs = ps.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("name"));
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

    /**
     * Get cities.
     * @param country string.
     * @return List.
     */
    public List<City> getCities(String country) {
        List<City> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = this.ds.getConnection();
            ps = connection.prepareStatement("SELECT ci.id, ci.name FROM cities ci LEFT JOIN countries co ON ci.country_id = co.id WHERE co.name = ?");
            ps.setString(1, country);
            rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new City(rs.getInt("id"), rs.getString("name")));
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

    /**
     * Set role to user.
     * @param login string.
     * @param role_id int.
     */
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

    /**
     * Set city to user.
     * @param login string.
     * @param city_id int.
     */
    public void setCity(String login, int city_id) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = this.ds.getConnection();
            ps = connection.prepareStatement("UPDATE sec_users SET city_id = ? WHERE login = ?");
            ps.setInt(1, city_id);
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
