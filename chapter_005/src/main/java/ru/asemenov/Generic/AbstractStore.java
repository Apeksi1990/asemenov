package ru.asemenov.Generic;
/**
 * Class AbstractStore решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <T> generic.
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    /**
     * Size.
     */
    private int size = 0;
    /**
     * Storage.
     */
    private SimpleArray<T> storage;
    /**
     * Add value.
     * @param value add.
     */
    public void add(T value) {
        this.storage.add(value);
    }

    /**
     * AbstractStore constructor.
     * @param size storage.
     */
    public AbstractStore(int size) {
        this.storage = new SimpleArray<>(size);
        this.size = size;
    }
    /**
     * Get value.
     * @param id value.
     * @return value.
     */
    public T get(String id) {
        T result = null;
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
    public void update(String id, T value) {
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
    public void delete(String id) {
        for (int i = 0; i < this.size; i++) {
            if (id.equals(this.storage.get(i).getId())) {
                this.storage.delete(i);
                break;
            }
        }
    }
}
