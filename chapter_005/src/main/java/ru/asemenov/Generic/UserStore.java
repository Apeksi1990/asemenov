package ru.asemenov.Generic;

public class UserStore implements Store<User> {

    private SimpleArray<User> storage;

    public UserStore(int size) {
        this.storage = new SimpleArray<>(size);
    }

    /**
     * Add value.
     * @param value add.
     */
    @Override
    public void add(User value) {

    }

    /**
     * Get value.
     * @param id value.
     * @return value.
     */
    @Override
    public User get(String id) {
        return null;
    }

    /**
     * Update value.
     * @param id    value.
     * @param value new.
     */
    @Override
    public void update(String id, User value) {

    }

    /**
     * Delete value.
     * @param id value.
     */
    @Override
    public void delete(String id) {

    }
}
