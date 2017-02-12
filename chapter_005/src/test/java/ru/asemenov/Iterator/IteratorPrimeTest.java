package ru.asemenov.Iterator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
/**
 * Class IteratorEven решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class IteratorPrimeTest {
    /**
     * Test on prime number.
     */
    @Test
    public void whenGiveArrayThenPrintPrimeNumber() {
        IteratorPrime iteratorPrime = new IteratorPrime(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13});
        iteratorPrime.next();
        iteratorPrime.next();
        iteratorPrime.next();
        int result = (Integer) iteratorPrime.next();
        assertThat(result, is(7));
    }
}