package ru.asemenov.factory;

import ru.asemenov.daoInterface.RoleDAO;
import ru.asemenov.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreSqlRoleDao implements RoleDAO {

    private DAOFactory factory;

    public PostgreSqlRoleDao(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(String name) {

    }

    @Override
    public List<Role> getAll() {
        List<Role> result = new ArrayList<>();
        String sql = "SELECT * FROM role";
        try (Connection connection = this.factory.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("name"));
                result.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Role findById(int id) {
        return null;
    }

    @Override
    public void update(int id, String name) {

    }

    @Override
    public void delete(int id) {

    }
}
