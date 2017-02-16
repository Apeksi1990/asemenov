package ru.asemenov.List;
/**
 * Interface SimpleStack решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <E> generic.
 */
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
