package ru.asemenov.Iterator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
/**
 * Class IteratorEven решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class IteratorEvenTest {
    /**
     * Test on even number.
     */
    @Test
    public void whenGiveArrayThenPrintEvenNumber() {
        IteratorEven iteratorEven = new IteratorEven(new int[]{1, 2, 3, 4, 5, 6});
        iteratorEven.next();
        int result = (Integer) iteratorEven.next();
        assertThat(result, is(4));
    }
}