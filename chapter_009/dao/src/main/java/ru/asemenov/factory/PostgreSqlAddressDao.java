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

    public PostgreSqlAddressDao(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(String name) {

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
        return null;
    }

    @Override
    public void update(int id, String name) {

    }

    @Override
    public void delete(int id) {

    }
}
