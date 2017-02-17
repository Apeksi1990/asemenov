package ru.asemenov.Set;

import java.util.Iterator;
/**
 * Class LinkedSet решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <T> generic.
 */
public class LinkedSet<T> implements SimpleSet<T> {
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
     * Add element.
     * @param t element
     */
    @Override
    public void add(T t) {
        if (this.first == null) {
            Entry<T> entry = new Entry<>(t, null, null);
            this.first = entry;
            this.last = entry;
            this.index++;
        } else if (checkElement(t)) {
            Entry<T> prev = this.last;
            this.last = new Entry<>(t, prev, null);
            prev.next = this.last;
            this.index++;
        }
    }

    /**
     * Check element.
     * @param t element.
     * @return boolean.
     */
    private boolean checkElement(T t) {
        boolean result = true;
        Entry<T> current = this.first;
        while (current != null) {
            if (t.equals(current.element)) {
                result = false;
                break;
            } else {
                current = current.next;
            }
        }
        return result;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedSetIterator<>();
    }

    /**
     * Iterator.
     * @param <I>
     */
    private class LinkedSetIterator<I> implements Iterator<I> {
        /**
         * Current entry element.
         */
        private Entry<T> current = first;
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
                Entry<T> result = current;
                current = current.next;
                position++;
                return (I) result.element;
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }

    /**
     * Entry.
     * @param <E>
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
