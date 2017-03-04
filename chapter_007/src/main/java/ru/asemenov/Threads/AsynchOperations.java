package ru.asemenov.Threads;
/**
 * Class AsynchOperations решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class AsynchOperations {
    /**
     * Calculate.
     */
    public static class Calculate implements Runnable {
        /**
         * Name.
         */
        private final String name;

        /**
         * Calculate constructor.
         * @param name this.
         */
        public Calculate(String name) {
            this.name = name;
        }

        /**
         * Override run.
         */
        @Override
        public void run() {
            System.out.println(String.format("%s TODO Asynch", this.name));
        }
    }

    /**
     * Main.
     * @param args arg.
     */
    public static void main(String[] args) {
        System.out.println("Start");
        new Thread(new Calculate("thread 1")).start();
        new Thread(new Calculate("thread 2")).start();
        System.out.println("Finish");
    }
}
