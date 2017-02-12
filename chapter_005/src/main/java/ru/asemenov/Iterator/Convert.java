package ru.asemenov.Iterator;

import java.util.Iterator;
/**
 * Interface Convert решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public interface Convert extends Iterator {
    /**
     * Convert.
     * @param it iterator.
     * @return value.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it);
}
