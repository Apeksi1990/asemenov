package ru.asemenov.JMM;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
/**
 * Class CounterProblemTest решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class CounterProblemTest {
    /**
     * Problem count test.
     * @throws InterruptedException exception.
     */
    @Test
    public void whenStartThreadThenRreturnFalseCount() throws InterruptedException {
        Counter counter = new Counter();

        for (int i = 0; i < 200; i++) {
            CounterThread ct = new CounterThread(counter);
            ct.start();
        }
        Thread.sleep(1000);

        boolean result = counter.getCounter() == 200000;
        Assert.assertThat(result, is(false));
    }
}