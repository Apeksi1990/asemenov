package ru.asemenov.WaitNotify;
/**
 * Class Lock решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class Lock {
    /**
     * Locked.
     */
    private boolean locked = false;

    /**
     * Set lock.
     * @throws InterruptedException exception.
     */
    public synchronized void setLocked() throws InterruptedException {
        while (this.locked) {
            wait();
        }
        this.locked = true;
    }

    /**
     * Unlocking.
     */
    public synchronized void unlocking() {
        this.locked = false;
        notify();
    }
}
