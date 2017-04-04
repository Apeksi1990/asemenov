package ru.asemenov.NonBlocking;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * Class NonBlock решение задачи части 007.
 * @author asemenov
 * @version 1
 * @param <K>
 * @param <V>
 */
public class NonBlock<K, V extends Model> {
    /**
     * Cache.
     */
    private final Map<K, V> cache = new ConcurrentHashMap<>();

    /**
     * Add model.
     * @param key model.
     * @param model  model.
     */
    public void add(K key, V model) {
        this.cache.put(key, model);
    }

    /**
     * Update model.
     * @param key model.
     */
    public void update(K key) {
        int version = this.cache.get(key).getVersion();
        if (version == this.cache.get(key).getVersion()) {
            this.cache.get(key).setVersion();
        } else {
            throw  new OplimisticException();
        }

    }

    /**
     * Delete.
     * @param key model.
     */
    public void delete(K key) {
        this.cache.remove(key);
    }

    /**
     * Get model.
     * @param key model.
     * @return model.toString.
     */
    public String getModel(K key) {
        return this.cache.get(key).toString();
    }

}
