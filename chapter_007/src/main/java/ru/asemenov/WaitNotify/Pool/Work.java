package ru.asemenov.WaitNotify.Pool;
/**
 * Class Work решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class Work implements Runnable {
    /**
     * Work name.
     */
    private String name;

    /**
     * Work constructor.
     * @param name this.
     */
    public Work(String name) {
        this.name = name;
    }

    /**
     * Override run.
     */
    @Override
    public void run() {
        System.out.println(String.format("Work name: %s; ThreadName: %s", this.name, Thread.currentThread().getName()));
    }
}
