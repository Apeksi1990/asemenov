package ru.asemenov.List;

import java.util.Arrays;
import java.util.Iterator;
/**
 * Class DynamicList решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <T> generic.
 */
public class DynamicList<T> implements SimpleContainer<T> {
    /**
     * Objects.
     */
    private Object[] objects;
    /**
     * Index position.
     */
    private int index = 0;

    /**
     * DynamicList constructor.
     * @param size objects.
     */
    public DynamicList(int size) {
        this.objects = new Object[size];
    }

    /**
     * Add.
     * @param t value.
     */
    @Override
    public void add(T t) {
        if (this.index >= this.objects.length) {
            this.objects = Arrays.copyOf(this.objects, this.objects.length * 2);
        }
        this.objects[index++] = t;
    }

    /**
     * Get value index.
     * @param index E value.
     * @return E value.
     */
    @Override
    public T get(int index) {
        return (T) this.objects[index];
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new DynamicIterator<>();
    }

    /**
     * DynamicIterator.
     * @param <I> generic.
     */
    private class DynamicIterator<I> implements Iterator<I> {
        /**
         * Position.
         */
        private int position = 0;
        /**
         * Has next.
         */
        @Override
        public boolean hasNext() {
            return this.position < index;
        }

        /**
         * Next.
         */
        @Override
        public I next() {
            if (this.hasNext()) {
                return (I) get(this.position++);
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }
}
