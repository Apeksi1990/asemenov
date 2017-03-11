package ru.asemenov.WaitNotify.ProducerCustomer;
/**
 * Class Producer решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class Producer implements Runnable {
    /**
     * Storage.
     */
    private Storage storage;

    /**
     * Producer constructor.
     * @param storage queue.
     */
    public Producer(Storage storage) {
        this.storage = storage;
    }

    /**
     * Override run.
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.storage.add("Element " + String.valueOf(i));
        }
    }
}
