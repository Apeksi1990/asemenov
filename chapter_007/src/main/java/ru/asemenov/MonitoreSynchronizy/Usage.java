package ru.asemenov.MonitoreSynchronizy;
/**
 * Class Usage решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class Usage {
    /**
     * Class Counter.
     */
    public static final class Counter {
        /**
         * Count.
         */
        private long count = 0;

        /**
         * Add.
         * @param value value.
         */
        public synchronized void add(long value) {
            this.count += value;
        }
    }

    /**
     * Class CounterThread.
     */
    public static final class CounterThread extends Thread {
        /**
         * Counter.
         */
        private final Counter counter;

        /**
         * CounterThread constructor.
         * @param counter this.
         */
        public CounterThread(final Counter counter) {
            this.counter = counter;
        }

        /**
         * Override run.
         */
        @Override
        public void run() {
            counter.add(1);
        }
    }

    /**
     * Main.
     * @param args ard.
     * @throws InterruptedException exception.
     */
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread threadA = new CounterThread(counter);
        Thread threadB = new CounterThread(counter);

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println(counter.count);
    }
}
