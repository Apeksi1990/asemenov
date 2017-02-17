package ru.asemenov.Set;
/**
 * Interface SimpleSet решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <E> generic.
 */
public interface SimpleSet<E> extends Iterable<E> {
    /**
     * Add element.
     * @param e element.
     */
    void add(E e);
}
