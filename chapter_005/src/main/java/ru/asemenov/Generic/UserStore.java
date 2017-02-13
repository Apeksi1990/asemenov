package ru.asemenov.Generic;
/**
 * Class UserStore решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class UserStore implements Store<User> {
    /**
     * Storage user.
     */
    private SimpleArray<User> storage;
    /**
     * Size.
     */
    private int size = 0;

    /**
     * UserStore constructor.
     * @param size storage.
     */
    public UserStore(int size) {
        this.storage = new SimpleArray<>(size);
        this.size = size;
    }

    /**
     * Add value.
     * @param value add.
     */
    @Override
    public void add(User value) {
        this.storage.add(value);
    }

    /**
     * Get value.
     * @param id value.
     * @return value.
     */
    @Override
    public User get(String id) {
        User result = null;
        for (int i = 0; i < this.size; i++) {
            if (id.equals(this.storage.get(i).getId())) {
                result = this.storage.get(i);
                break;
            }
        }
        return result;
    }

    /**
     * Update value.
     * @param id    value.
     * @param value new.
     */
    @Override
    public void update(String id, User value) {
        for (int i = 0; i < this.size; i++) {
            if (id.equals(this.storage.get(i).getId())) {
                this.storage.update(i, value);
                break;
            }
        }
    }

    /**
     * Delete value.
     * @param id value.
     */
    @Override
    public void delete(String id) {
        for (int i = 0; i < this.size; i++) {
            if (id.equals(this.storage.get(i).getId())) {
                this.storage.delete(i);
                break;
            }
        }
    }
}
