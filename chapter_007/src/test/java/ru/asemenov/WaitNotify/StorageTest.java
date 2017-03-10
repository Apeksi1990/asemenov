package ru.asemenov.WaitNotify;

import org.junit.Test;
/**
 * Class StorageTest решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class StorageTest {
    /**
     * ProducerCustomer test.
     */
    @Test
    public void producerCustomer() {
        Storage storage = new Storage();
        Thread producer = new Thread(new Producer(storage));
        Thread customer = new Thread(new Customer(storage));

        producer.start();
        customer.start();
    }
}