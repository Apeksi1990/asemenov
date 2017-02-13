package ru.asemenov.Generic;
/**
 * Interface Store решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <T> generic.
 */
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
