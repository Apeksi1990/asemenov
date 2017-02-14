package ru.asemenov.List;

public interface SimpleQueue<E> {
    /**
     * Push element.
     * @param e element.
     */
    void push(E e);

    /**
     * Get element.
     * @return element.
     */
    E poll();
}
