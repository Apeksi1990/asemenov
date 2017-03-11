package ru.asemenov.WaitNotify.Pool;

import java.util.LinkedList;
/**
 * Class ThreadPool решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class ThreadPool {
    /**
     * Number of processors.
     */
    private final int processor = Runtime.getRuntime().availableProcessors();
    /**
     * Threads.
     */
    private final PoolWorker[] threads;
    /**
     * Queue.
     */
    private final LinkedList<Work> queue;

    /**
     * ThreadPool constructor.
     */
    public ThreadPool() {
        queue = new LinkedList<>();
        threads = new PoolWorker[processor];

        for (int i = 0; i < processor; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add work.
     * @param work Work.
     */
    public void add(Work work) {
        synchronized (queue) {
            queue.addLast(work);
            queue.notify();
        }
    }

    /**
     * Pool Worker.
     */
    private class PoolWorker extends Thread {
        /**
         * Override run.
         */
        @Override
        public void run() {
            Work work;
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    work = queue.removeFirst();
                }
                try {
                    work.run();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
