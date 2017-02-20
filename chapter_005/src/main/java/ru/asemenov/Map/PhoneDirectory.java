package ru.asemenov.Map;

import java.util.Arrays;
import java.util.Iterator;
/**
 * Class PhoneDirectory решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <T>
 * @param <V>
 */
public class PhoneDirectory<T, V> implements Directory<T, V> {
    /**
     * Storage phone.
     */
    private Entry<T, V>[] storage;

    /**
     * Position element.
     */
    private int index = 0;

    /**
     * PhoneDirectory constructor.
     * @param size storage.
     */
    PhoneDirectory(int size) {
        storage = new Entry[size];
    }

    /**
     * Insert.
     * @param key   value.
     * @param value element.
     * @return boolean.
     */
    @Override
    public boolean insert(T key, V value) {
        boolean result = true;
        if (key == null) {
            result = false;
        } else if (checkNew(key, value)) {
            add(key, value);
        }
        return result;
    }

    /**
     * Check new element.
     * @param key  element.
     * @param value element.
     * @return boolean.
     */
    private boolean checkNew(T key, V value) {
        boolean result = true;
        if (this.storage[getIndex(key)] != null) {
            this.storage[getIndex(key)].setValue(value);
            result = false;
        }
        return result;
    }

    /**
     * Set index.
     * @param key element.
     * @return int.
     */
    private int getIndex(T key) {
        return key.hashCode() % this.storage.length;
    }

    /**
     * Add element.
     * @param key  element.
     * @param value element.
     */
    public void add(T key, V value) {
        if (this.index >= this.storage.length) {
            this.storage = Arrays.copyOf(this.storage, this.storage.length * 2);
        }
        this.storage[getIndex(key)] = new Entry<>(key, value);
        this.index++;
    }

    /**
     * Get.
     * @param key value.
     * @return V.
     */
    @Override
    public V get(T key) {
        return this.storage[getIndex(key)].getValue();
    }

    /**
     * Delete.
     * @param key value.
     * @return boolean.
     */
    @Override
    public boolean delete(T key) {
        boolean result = true;
        if (key == null) {
            result = false;
        } else {
            if (this.storage[getIndex(key)] != null) {
                this.storage[getIndex(key)] = null;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<V> iterator() {
        return new DirectoryIterator<>();
    }

    /**
     * Entry.
     * @param <P>
     * @param <N>
     */
    private class Entry<P, N> {
        /**
         * Phone.
         */
        private P key;
        /**
         * Name.
         */
        private N value;

        /**
         * Entry constructor.
         * @param key element.
         * @param value element.
         */
        Entry(P key, N value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Get key.
         * @return phone.
         */
        public P getKey() {
            return this.key;
        }

        /**
         * Get name.
         * @return name.
         */
        public N getValue() {
            return this.value;
        }

        /**
         * Set value.
         * @param value new.
         */
        public void setValue(N value) {
            this.value = value;
        }
    }

    /**
     * Iterator.
     * @param <N>
     */
    private class DirectoryIterator<N> implements Iterator<N> {
        /**
         * Position.
         */
        private int position = 0;
        /**
         * Has next.
         */
        @Override
        public boolean hasNext() {
            boolean result = false;
            for (int i = position; i < storage.length; i++) {
                if (storage[i] != null) {
                    result = true;
                    break;
                } else {
                    position++;
                }
            }
            return result;
        }

        /**
         * Next.
         */
        @Override
        public N next() {
            if (this.hasNext()) {
                return (N) storage[position++].getValue();
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }
}
