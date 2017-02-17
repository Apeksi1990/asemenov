package ru.asemenov.Set;

import java.util.Arrays;
import java.util.Iterator;
/**
 * Class ArraySet решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <E> generic.
 */
public class ArraySet<E> implements SimpleSet<E> {
    /**
     * Objects.
     */
    private Object[] objects;
    /**
     * Index position.
     */
    private int index = 0;

    /**
     * ArraySet constructor.
     * @param size objects.
     */
    public ArraySet(int size) {
        objects = new Object[size];
    }

    /**
     * Add element.
     * @param e element
     */
    @Override
    public void add(E e) {
        if (checkElement(e)) {
            if (this.index >= this.objects.length) {
                this.objects = Arrays.copyOf(this.objects, this.objects.length * 2);
            }
            this.objects[index++] = e;
        }
    }

    /**
     * Check element.
     * @param e element.
     * @return boolean.
     */
    private boolean checkElement(E e) {
        boolean result = true;
        for (Object object : objects) {
            if (e.equals(object)) {
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
    public Iterator<E> iterator() {
        return new SetIterator<>();
    }

    /**
     * DynamicIterator.
     * @param <I> generic.
     */
    private class SetIterator<I> implements Iterator<I> {
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
                return (I) objects[position++];
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }
}
