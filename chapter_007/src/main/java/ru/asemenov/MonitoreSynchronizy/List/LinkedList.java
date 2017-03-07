package ru.asemenov.MonitoreSynchronizy.List;

import java.util.Iterator;

/**
 * Class LinkedList решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <T> generic.
 */
public class LinkedList<T> implements SimpleContainer<T> {
    /**
     * First.
     */
    private Entry<T> first;

    /**
     * Last.
     */
    private Entry<T> last;

    /**
     * Index position.
     */
    private int index = 0;

    /**
     * Add.
     * @param t value.
     */
    @Override
    public synchronized void add(T t) {
        if (this.first == null) {
            Entry<T> entry = new Entry<>(t, null, null);
            this.first = entry;
            this.last = entry;
        } else {
            Entry<T> prev = this.last;
            this.last = new Entry<>(t, prev, null);
            prev.next = this.last;
        }
        this.index++;
    }

    /**
     * Get value index.
     * @param index E value.
     * @return E value.
     */
    @Override
    public synchronized T get(int index) {
        T result = null;
        Entry<T> current = this.first;
        int count = 0;
        while (current != null) {
            if (count == index) {
                result = current.element;
                break;
            }
            current = current.next;
            count++;
        }
        return result;
    }

    /**
     * Delete element.
     * @param index element.
     */
    public synchronized void delete(int index) {
        Entry<T> current = first;
        int count = 0;
        while (current != null) {
            if (count == index) {
                Entry<T> prev = current.prev;
                Entry<T> next = current.next;
                if (prev == null && next == null) {
                    this.first = null;
                    this.last = null;
                } else if (next == null) {
                    prev.next = null;
                    this.last = prev;
                } else if (prev == null) {
                    next.prev = null;
                    this.first = next;
                } else {
                    prev.next = next;
                    next.prev = prev;
                }
                break;
            }
            current = current.next;
            count++;
        }
        this.index--;
    }

    /**
     * Get size.
     * @return size.
     */
    public synchronized int size() {
        return this.index;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>();
    }

    /**
     * LinkedListIterator.
     * @param <I> generic.
     */
    private class LinkedListIterator<I> implements Iterator<I> {
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
                return (I) get(position++);
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }

    /**
     * Entry.
     * @param <E> generic.
     */
    private class Entry<E> {
        /**
         * Element.
         */
        private E element;
        /**
         * Next element.
         */
        private Entry<E> next;
        /**
         * Previous element.
         */
        private Entry<E> prev;

        /**
         * Entry constructor.
         * @param element T.
         * @param prev element.
         * @param next element.
         */
        Entry(E element, Entry<E> prev, Entry<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
