package ru.asemenov.daoInterface;

import ru.asemenov.models.User;

import java.util.List;

public interface UserDAO {
    void create(String name);
    List<User> getAll();
    User findById(int id);
    void update(int id, String name);
    void delete(int id);
}
