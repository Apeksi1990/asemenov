package ru.asemenov.MonitoreSynchronizy.Counter;
/**
 * Class Counter решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class Counter {
    /**
     * Counter.
     */
    private long counter = 0;

    /**
     * Increase counter.
     */
    public synchronized void increment() {
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
