package ru.asemenov.WaitNotify;

import org.junit.Test;
import ru.asemenov.WaitNotify.ProducerCustomer.Customer;
import ru.asemenov.WaitNotify.ProducerCustomer.Producer;
import ru.asemenov.WaitNotify.ProducerCustomer.Storage;

/**
 * Class StorageTest решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class StorageTest {
    /**
     * ProducerCustomer test.
     * @throws InterruptedException exception.
     */
    @Test
    public void producerCustomer() throws InterruptedException {
        Storage storage = new Storage();
        Thread producer = new Thread(new Producer(storage));
        Thread customer = new Thread(new Customer(storage));

        producer.start();
        customer.start();
        producer.join();
        customer.join();
    }
}