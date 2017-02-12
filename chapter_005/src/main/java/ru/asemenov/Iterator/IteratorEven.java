package ru.asemenov.Iterator;

import java.util.Iterator;
/**
 * Class IteratorEven решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class IteratorEven implements Iterator {
    /**
     * Value.
     */
    private final int[] value;
    /**
     * Index.
     */
    private int index = 0;

    /**
     * IteratorEven constructor.
     * @param value int[].
     */
    public IteratorEven(int[] value) {
        this.value = value;
    }

    /**
     * Has next.
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        return value.length > index;
    }

    /**
     * Next.
     * @return value.
     */
    @Override
    public Object next() {
        while (!(value[index] % 2 == 0)) {
            index++;
        }
        return value[index++];
    }
}