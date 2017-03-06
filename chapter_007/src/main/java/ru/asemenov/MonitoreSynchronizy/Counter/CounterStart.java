package ru.asemenov.MonitoreSynchronizy.Counter;

/**
 * Class CounterStart решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class CounterStart {
    /**
     * Main.
     * @param args arg.
     * @throws InterruptedException exception.
     */
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        CounterThread ctA = new CounterThread(counter);
        CounterThread ctB = new CounterThread(counter);

        ctA.start();
        ctB.start();
        ctA.join();
        ctB.join();

        System.out.println("Counter:" + counter.getCounter());
    }
}
