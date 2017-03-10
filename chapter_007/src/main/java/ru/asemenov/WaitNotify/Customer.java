package ru.asemenov.WaitNotify;
/**
 * Class Customer решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class Customer implements Runnable {
    /**
     * Storage.
     */
    private Storage storage;

    /**
     * Customer constructor.
     * @param storage queue.
     */
    public Customer(Storage storage) {
        this.storage = storage;
    }

    /**
     * Override run.
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                this.storage.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
