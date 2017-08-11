package ru.asemenov.factory;

import ru.asemenov.daoInterface.UserDAO;
import ru.asemenov.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreSqlUserDao implements UserDAO {

    private DAOFactory factory;

    public PostgreSqlUserDao(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(String name) {

    }

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try (Connection connection = this.factory.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                result.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void update(int id, String name) {

    }

    @Override
    public void delete(int id) {

    }
}
