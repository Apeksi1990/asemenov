package ru.asemenov.jdbc;

import java.sql.*;
import java.util.ArrayList;

public class TrackerSQL {

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

    public void add(String name, String description) {
        try {
            PreparedStatement ps = connector().prepareStatement("INSERT INTO item(name, description, create_date) VALUES (?,?,?)");
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            ps.executeUpdate();
            ps.close();
            connector().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, String name, String description) {
        try {
            PreparedStatement ps = connector().prepareStatement("UPDATE item SET name = ?, description = ? where id = ?");
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setInt(3, id);
            ps.executeUpdate();
            ps.close();
            connector().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement ps = connector().prepareStatement("DELETE FROM item where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            connector().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Item> findAll() {
        ArrayList<Item> result = new ArrayList<>();
        try {
            PreparedStatement ps = connector().prepareStatement("SELECT * FROM item");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Item(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getTimestamp("create_date")));
            }
            ps.close();
            rs.close();
            connector().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Item findById(int id) {
        Item result = null;
        try {
            PreparedStatement ps = connector().prepareStatement("SELECT * FROM item WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = new Item(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getTimestamp("create_date"));
            }
            ps.close();
            rs.close();
            connector().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Item findByName(String name) {
        Item result = null;
        try {
            PreparedStatement ps = connector().prepareStatement("SELECT * FROM item WHERE name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = new Item(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getTimestamp("create_date"));
            }
            ps.close();
            rs.close();
            connector().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void addComment(int id, String comment) {
        try {
            PreparedStatement ps = connector().prepareStatement("INSERT INTO comments(comment, item_id) VALUES (?,?)");
            ps.setString(1, comment);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            connector().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
