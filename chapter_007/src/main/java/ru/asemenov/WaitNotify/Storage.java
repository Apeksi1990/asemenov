package ru.asemenov.WaitNotify;

import java.util.PriorityQueue;
import java.util.Queue;
/**
 * Class Storage решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class Storage {
    /**
     * Queue storage.
     */
    private Queue<String> storage = new PriorityQueue<>();

    /**
     * Add data.
     * @param data E.
     */
    public synchronized void add(String data) {
        this.storage.offer(data);
        System.out.println("Add data");
        notify();
    }

    /**
     * Get data.
     * @throws InterruptedException exception.
     */
    public synchronized void get() throws InterruptedException {
        while (this.storage.peek() == null) {
            wait();
            System.out.println("Wait!");
        }
        System.out.println(this.storage.poll());
    }
}
