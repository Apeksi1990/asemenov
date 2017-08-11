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

    public PostgreSqlMusicTypeDao(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(String name) {

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
        return null;
    }

    @Override
    public void update(int id, String name) {

    }

    @Override
    public void delete(int id) {

    }
}
