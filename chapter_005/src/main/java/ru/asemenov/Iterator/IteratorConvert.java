package ru.asemenov.Iterator;

import java.util.Iterator;
/**
 * Class IteratorConvert решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class IteratorConvert implements Convert {
    /**
     * It.
     */
    private Iterator<Iterator<Integer>> it;
    /**
     * Iterator.
     */
    private Iterator<Integer> current;

    /**
     * Convert.
     * @param it iterator.
     * @return value.
     */
    @Override
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.it = it;
        return this;
    }

    /**
     * Has next.
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        return it.hasNext() || (current != null && current.hasNext());
    }

    /**
     * Next.
     * @return value.
     */
    @Override
    public Object next() {
        if (current == null) {
            current = it.next();
        } else if (!current.hasNext()) {
            current = it.next();
        }
        return current.next();
    }
}
