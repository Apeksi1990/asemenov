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
        boolean result = false;
        if (index >= value.length) {
            result = false;
        } else {
            while (index < value.length) {
                if (value[index] % 2 == 0) {
                    result = true;
                    break;
                } else {
                    index++;
                }
            }
        }
        return result;
    }

    /**
     * Next.
     * @return value.
     */
    @Override
    public Object next() {
        if (hasNext()) {
            Object result = value[index];
            index++;
            return result;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}