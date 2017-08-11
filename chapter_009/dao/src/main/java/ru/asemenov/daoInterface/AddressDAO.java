package ru.asemenov.daoInterface;

import ru.asemenov.models.Address;

import java.util.List;

public interface AddressDAO {
    void create(String name);
    List<Address> getAll();
    Address findById(int id);
    void update(int id, String name);
    void delete(int id);
}
