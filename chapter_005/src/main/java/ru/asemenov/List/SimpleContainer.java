package ru.asemenov.List;

import java.util.Iterator;

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
