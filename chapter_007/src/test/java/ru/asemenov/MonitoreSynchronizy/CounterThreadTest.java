package ru.asemenov.MonitoreSynchronizy;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
/**
 * Class CounterThreadTest решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class CounterThreadTest {
    /**
     * Counter synchronized test.
     * @throws InterruptedException exception.
     */
    @Test
    public void whenTwoThreadThenCorrectCount() throws InterruptedException {
        Counter counter = new Counter();

        CounterThread ctA = new CounterThread(counter);
        CounterThread ctB = new CounterThread(counter);

        ctA.start();
        ctB.start();
        ctA.join();
        ctB.join();

        long result = counter.getCounter();

        Assert.assertThat(result, is(20000L));
    }
}