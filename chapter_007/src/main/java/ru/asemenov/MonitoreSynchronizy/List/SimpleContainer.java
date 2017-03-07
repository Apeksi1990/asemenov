package ru.asemenov.MonitoreSynchronizy.List;

/**
 * Interface SimpleContainer решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <E> generic.
 */
public interface SimpleContainer<E> extends Iterable<E> {
    /**
     * Add.
     * @param e value.
     */
    void add(E e);

    /**
     * Get value index.
     * @param index E value.
     * @return E value.
     */
    E get(int index);
}
