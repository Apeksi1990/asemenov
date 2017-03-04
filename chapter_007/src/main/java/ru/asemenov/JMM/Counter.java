package ru.asemenov.JMM;
/**
 * Class Counter решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class Counter {
    /**
     * Counter.
     */
    private long counter = 0L;

    /**
     * Increase counter.
     */
    public void increaseCounter() {
        counter++;
    }

    /**
     * Get counter.
     * @return counter.
     */
    public long getCounter() {
        return counter;
    }
}
