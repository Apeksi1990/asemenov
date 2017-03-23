package ru.asemenov.WaitNotify.ProducerCustomer;

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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get data.
     * @throws InterruptedException exception.
     */
    public synchronized void get() throws InterruptedException {
        while (this.storage.peek() == null) {
            System.out.println("Wait!");
            wait();
        }
        System.out.println(this.storage.poll());
    }
}
