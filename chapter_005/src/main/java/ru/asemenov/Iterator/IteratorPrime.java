package ru.asemenov.Iterator;

import java.util.Iterator;
/**
 * Class IteratorPrime решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class IteratorPrime implements Iterator {
    /**
     * Value.
     */
    private final int[] value;
    /**
     * Index.
     */
    private int index = 0;

    /**
     * IteratorPrime constructor.
     * @param value int[].
     */
    public IteratorPrime(int[] value) {
        this.value = value;
    }

    /**
     * Has next.
     * @return boolean.
     */
    @Override
    /*public boolean hasNext() {
        return value.length > index;
    }*/
    public boolean hasNext() {
        boolean result = false;
        while (!result) {
            if (index >= value.length) {
                break;
            } else {
                result = true;
                for (int i = 2; i <= value[index] / 2; i++) {
                    int temp = value[index] % i;
                    if (temp == 0) {
                        result = false;
                        index++;
                        break;
                    }
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
