package ru.asemenov.JMM;
/**
 * Class CounterThread решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class CounterThread extends Thread {
    /**
     * Counter.
     */
    private Counter counter;

    /**
     * CounterThread constructor.
     * @param counter this.
     */
    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    /**
     * Override run.
     */
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increaseCounter();
        }
    }
}
