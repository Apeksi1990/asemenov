package ru.asemenov.JMM;
/**
 * Class CounterProblem решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class CounterProblem {
    /**
     * Main.
     * @param args arg.
     * @throws InterruptedException exception.
     */
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        for (int i = 0; i < 200; i++) {
            CounterThread ct = new CounterThread(counter);
            ct.start();
        }
        Thread.sleep(1000);

        System.out.println("Counter:" + counter.getCounter());
    }
}
