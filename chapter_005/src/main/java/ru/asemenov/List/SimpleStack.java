package ru.asemenov.List;

public interface SimpleStack<E> {
    /**
     * Push element.
     * @param e element.
     */
    void push(E e);

    /**
     * Get element.
     * @return element.
     */
    E pop();
}
