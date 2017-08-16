package ru.asemenov.factory;

import ru.asemenov.daoInterface.UserDAO;
import ru.asemenov.models.MusicType;
import ru.asemenov.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgreSqlUserDao implements UserDAO {

    private DAOFactory factory;

    PostgreSqlUserDao(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(String name, String login, String password, int address, int role, List<Integer> music) {
        String sql = "INSERT INTO users(name, login, password, address_id, role_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = this.factory.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, name);
            ps.setString(2, login);
            ps.setString(3, password);
            ps.setInt(4, address);
            ps.setInt(5, role);
            ps.executeUpdate();
            if (music.size() != 0) {
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                int id = rs.getInt(1);
                addMusicToUser(id, music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addMusicToUser(int id, List<Integer> music) {
        for (Integer i : music) {
            String sql = "INSERT INTO user_music(user_id, music_id) VALUES (?, ?)";
            try (Connection connection = this.factory.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, id);
                ps.setInt(2, i);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        String sql = "select u.id, u.name, u.login, a.name aname, r.name rname from users u left join address a on u.address_id = a.id left join role r on u.role_id = r.id";
        try (Connection connection = this.factory.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setLogin(rs.getString("login"));
                user.setAddress(rs.getString("aname"));
                user.setRoleId(rs.getString("rname"));
                user.setMusicType(getMusic(rs.getInt("id")));
                result.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private List<MusicType> getMusic(int id) {
        List<MusicType> result = new ArrayList<>();
        String sql = "select * from musictype mt  left join user_music um on mt.id = um.music_id where um.user_id = ?";
        try (Connection connection = this.factory.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
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
    public User findById(int id) {
        User result = new User();
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection connection = this.factory.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("name"));
                result.setLogin(rs.getString("login"));
                result.setAddress(rs.getString("aname"));
                result.setRoleId(rs.getString("rname"));
                result.setMusicType(getMusic(rs.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void update(int id, String name, String login, int address, int role, List<Integer> music) { //TODO доделать апдейт юзера
        String sql = "UPDATE users SET name = ?,  login = ?, address_id = ?, role_id = ?  WHERE id = ?";
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
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection connection = this.factory.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
