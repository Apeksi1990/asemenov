package ru.asemenov.factory;

import ru.asemenov.daoInterface.MusicTypeDAO;
import ru.asemenov.models.MusicType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreSqlMusicTypeDao implements MusicTypeDAO {

    private DAOFactory factory;

    PostgreSqlMusicTypeDao(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(String name) {
        String sql = "INSERT INTO musictype(name) VALUES (?)";
        try (Connection connection = this.factory.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
                 e.printStackTrace();
        }
    }

    @Override
    public List<MusicType> getAll() {
        List<MusicType> result = new ArrayList<>();
        String sql = "SELECT * FROM musictype";
        try (Connection connection = this.factory.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                MusicType musicType = new MusicType();
                musicType.setId(rs.getInt("id"));
                musicType.setName(rs.getString("name"));
                result.add(musicType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public MusicType findById(int id) {
        MusicType result = new MusicType();
        String sql = "SELECT * FROM musictype WHERE id = ?";
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
        String sql = "UPDATE musictype SET name = ? WHERE id = ?";
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
        String sql = "DELETE FROM musictype WHERE id = ?";
        try (Connection connection = this.factory.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
