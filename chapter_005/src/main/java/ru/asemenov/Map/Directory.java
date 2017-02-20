package ru.asemenov.Map;
/**
 * Class Directory решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <T>
 * @param <V>
 */
public interface Directory<T, V> extends Iterable<V> {
    /**
     * Insert.
     * @param key value.
     * @param value element.
     * @return boolean.
     */
    boolean insert(T key, V value);

    /**
     * Get.
     * @param key value.
     * @return V.
     */
    V get(T key);

    /**
     * Delete.
     * @param key value.
     * @return boolean.
     */
    boolean delete(T key);
}
