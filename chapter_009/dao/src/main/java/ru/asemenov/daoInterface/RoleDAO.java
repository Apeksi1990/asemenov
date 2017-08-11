package ru.asemenov.daoInterface;

import ru.asemenov.models.Role;

import java.util.List;

public interface RoleDAO {
    void create(String name);
    List<Role> getAll();
    Role findById(int id);
    void update(int id, String name);
    void delete(int id);
}
