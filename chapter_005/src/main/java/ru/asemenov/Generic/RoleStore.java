package ru.asemenov.Generic;
/**
 * Class RoleStore решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class RoleStore implements Store<Role> {
    /**
     * Storage roll.
     */
    private SimpleArray<Role> storage;
    /**
     * Size.
     */
    private int size = 0;

    /**
     * RoleStore constructor.
     * @param size storage.
     */
    public RoleStore(int size) {
        this.storage = new SimpleArray<>(size);
        this.size = size;
    }

    /**
     * Add value.
     * @param value add.
     */
    @Override
    public void add(Role value) {
        this.storage.add(value);
    }

    /**
     * Get value.
     * @param id value.
     * @return value.
     */
    @Override
    public Role get(String id) {
        Role result = null;
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
    public void update(String id, Role value) {
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
