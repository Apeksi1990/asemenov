package ru.asemenov.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
/**
 * Class TrackerSQL решение задачи части 008.
 * @author asemenov
 * @version 1
 */
public class TrackerSQL {
    /**
     * Connection to SQL.
     * @return connection.
     */
    private Connection connector() {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "password";
        try {
            connection =  DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Add item.
     * @param name String.
     * @param description String.
     */
    public void add(String name, String description) {
        PreparedStatement ps = null;
        try {
            ps = connector().prepareStatement("INSERT INTO item(name, description, create_date) VALUES (?,?,?)");
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    connector().close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Update item.
     * @param id new.
     * @param name new.
     * @param description new.
     */
    public void update(int id, String name, String description) {
        PreparedStatement ps = null;
        try {
            ps = connector().prepareStatement("UPDATE item SET name = ?, description = ? where id = ?");
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    connector().close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Delete item.
     * @param id delete.
     */
    public void delete(int id) {
        PreparedStatement ps = null;
        try {
            ps = connector().prepareStatement("DELETE FROM item where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    connector().close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Find all item.
     * @return List.
     */
    public ArrayList<Item> findAll() {
        ArrayList<Item> result = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            ps = connector().prepareStatement("SELECT * FROM item");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Item(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getTimestamp("create_date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    connector().close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * Find by id.
     * @param id find.
     * @return Item.
     */
    public Item findById(int id) {
        Item result = null;
        PreparedStatement ps = null;
        try {
            ps = connector().prepareStatement("SELECT * FROM item WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = new Item(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getTimestamp("create_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    connector().close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * Find by name.
     * @param name find.
     * @return Item.
     */
    public Item findByName(String name) {
        Item result = null;
        PreparedStatement ps = null;
        try {
            ps = connector().prepareStatement("SELECT * FROM item WHERE name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = new Item(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getTimestamp("create_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    connector().close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * Add comment to item.
     * @param id item.
     * @param comment String.
     */
    public void addComment(int id, String comment) {
        PreparedStatement ps = null;
        try {
            ps = connector().prepareStatement("INSERT INTO comments(comment, item_id) VALUES (?,?)");
            ps.setString(1, comment);
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    connector().close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
