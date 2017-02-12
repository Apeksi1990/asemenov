package ru.asemenov.Generic;

public class RoleStore implements Store<Role> {

    private SimpleArray<Role> storage;

    public RoleStore(int size) {
        this.storage = new SimpleArray<>(size);
    }

    /**
     * Add value.
     * @param value add.
     */
    @Override
    public void add(Role value) {

    }

    /**
     * Get value.
     * @param id value.
     * @return value.
     */
    @Override
    public Role get(String id) {
        return null;
    }

    /**
     * Update value.
     * @param id    value.
     * @param value new.
     */
    @Override
    public void update(String id, Role value) {

    }

    /**
     * Delete value.
     * @param id value.
     */
    @Override
    public void delete(String id) {

    }
}
