package ru.asemenov.factory;

import ru.asemenov.daoInterface.AddressDAO;
import ru.asemenov.models.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreSqlAddressDao implements AddressDAO {

    private DAOFactory factory;

    PostgreSqlAddressDao(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(String name) {
        String sql = "INSERT INTO address(name) VALUES (?)";
        try (Connection connection = this.factory.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
                 e.printStackTrace();
        }
    }

    @Override
    public List<Address> getAll() {
        List<Address> result = new ArrayList<>();
        String sql = "SELECT * FROM address";
        try (Connection connection = this.factory.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Address address = new Address();
                address.setId(rs.getInt("id"));
                address.setName(rs.getString("name"));
                result.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Address findById(int id) {
        Address result = new Address();
        String sql = "SELECT * FROM address WHERE id = ?";
        try (Connection connection = this.factory.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void update(int id, String name) {
        String sql = "UPDATE address SET name = ? WHERE id = ?";
        try (Connection connection = this.factory.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM address WHERE id = ?";
        try (Connection connection = this.factory.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
