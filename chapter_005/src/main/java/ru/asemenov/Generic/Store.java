package ru.asemenov.Generic;

public interface Store<T extends Base> {
    /**
     * Add value.
     * @param value add.
     */
    void add(T value);

    /**
     * Get value.
     * @param id value.
     * @return value.
     */
    T get(String id);

    /**
     * Update value.
     * @param id value.
     * @param value new.
     */
    void update(String id, T value);

    /**
     * Delete value.
     * @param id value.
     */
    void delete(String id);
}
