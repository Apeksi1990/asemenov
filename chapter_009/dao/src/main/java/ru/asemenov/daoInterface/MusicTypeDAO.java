package ru.asemenov.daoInterface;

import ru.asemenov.models.MusicType;

import java.util.List;

public interface MusicTypeDAO {
    void create(String name);
    List<MusicType> getAll();
    MusicType findById(int id);
    void update(int id, String name);
    void delete(int id);
}
