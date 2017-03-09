package ru.asemenov.WaitNotify;

import java.util.PriorityQueue;
import java.util.Queue;

public class ProducerCustomer<E> {
    /**
     * Queue storage.
     */
    private final Queue<E> lock = new PriorityQueue<>();

    private boolean finish = false;

    public void addData(E data) {
        synchronized (this.lock) {
            lock.offer(data);
            System.out.println("Элемент плюс");
            lock.notify();
        }
    }

    public void printData() throws InterruptedException {
        synchronized (this.lock) {
            while (this.lock.peek() != null) {
                System.out.println(this.lock.poll());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.lock.wait();
            System.out.println("Wait!!!");
        }
    }

    public static void main(String[] args) {
        ProducerCustomer<String> producerCustomer = new ProducerCustomer<>();

        //Добавление элемента в очередь
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    producerCustomer.addData("Element " + String.valueOf(i));
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //producerCustomer.finish = true;
            }
        }.start();

        //Печать элементов очереди
        new Thread() {
            @Override
            public void run() {
                while (!producerCustomer.finish) {
                    try {
                        producerCustomer.printData();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
