package ru.asemenov.List;

import java.util.Iterator;

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
    public void add(T t) {
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
    public T get(int index) {
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
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>();
    }

    private class LinkedListIterator<I> implements Iterator<I> {
        /**
         * Position.
         */
        int position = 0;
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

    private class Entry<E> {
        /**
         * Element.
         */
        E element;
        /**
         * Next element.
         */
        Entry<E> next;
        /**
         * Previous element.
         */
        Entry<E> prev;

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
