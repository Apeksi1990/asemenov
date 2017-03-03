package ru.asemenov.Threads;

public class AsynchOperations {
    public static class Calculate implements Runnable {
        private final String name;

        public Calculate(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(String.format("%s TODO Asynch", this.name));
        }
    }

    public static void main(String[] args) {
        System.out.println("Start");
        new Thread(new Calculate("thread 1")).start();
        new Thread(new Calculate("thread 2")).start();
        System.out.println("Finish");
    }
}
