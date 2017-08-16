package ru.asemenov.daoInterface;

import ru.asemenov.models.User;

import java.util.List;

public interface UserDAO {
    void create(String name, String login, String password, int address, int role, List<Integer> music);
    List<User> getAll();
    User findById(int id);
    void update(int id, String name, String login, int address, int role, List<Integer> music);
    void delete(int id);
}
