package ru.asemenov.Map;

import java.util.Arrays;
import java.util.Iterator;

public class PhoneDirectory<T, V> implements Directory<T, V> {
    /**
     * Storage phone.
     */
    private Entry<T, V>[] storage;

    /**
     * Position element.
     */
    private int position = 0;

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
        }else if (checkNew(key, value)){
            add(key, value);
        }
        return result;
    }

    private boolean checkNew(T key, V value) {
        boolean result = true;
        Entry<T, V> newValue = new Entry<>(key, value);
        for (int i = 0; i < this.position; i++) {
            if (key.hashCode() == this.storage[i].getKey().hashCode()) {
                this.storage[i] = newValue;
                result = false;
                break;
            }
        }
        return result;
    }

    public void add(T key, V value) {
        if (this.position >= this.storage.length) {
            this.storage = Arrays.copyOf(this.storage, this.storage.length * 2);
        }
        this.storage[position++] = new Entry<>(key, value);
    }

    /**
     * Get.
     * @param key value.
     * @return V.
     */
    @Override
    public V get(T key) {
        V result = null;
        for (int i = 0; i < this.storage.length; i++) {
            if (key.hashCode() == this.storage[i].getKey().hashCode()) {
                result = this.storage[i].getValue();
                break;
            }
        }
        return result;
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
            for (int i = 0; i < this.storage.length; i++) {
                if (key.hashCode() == this.storage[i].getKey().hashCode()) {
                    this.storage[i] = null;
                    break;
                }
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
        public Entry(P key, N value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Get key.
         * @return phone.
         */
        public P getKey() {
            return key;
        }

        /**
         * Get name.
         * @return name.
         */
        public N getValue() {
            return value;
        }
    }

    private class DirectoryIterator<N> implements Iterator<N> {
        /**
         * Position.
         */
        private int index = 0;
        /**
         * Has next.
         */
        @Override
        public boolean hasNext() {
            return index < position;
        }

        /**
         * Next.
         */
        @Override
        public N next() {
            if (this.hasNext()) {
                return (N) storage[index++].getValue();
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }
}
