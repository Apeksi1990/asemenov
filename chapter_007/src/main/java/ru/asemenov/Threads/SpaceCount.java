package ru.asemenov.Threads;
/**
 * Class SpaceCount решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class SpaceCount implements Runnable {
    /**
     * Count.
     */
    private int count = 0;
    /**
     * Message.
     */
    private String message;

    /**
     * SpaceCount constructor.
     * @param message count.
     */
    public SpaceCount(String message) {
        this.message = message;
    }

    /**
     * Override run.
     */
    @Override
    public void run() {
        char[] chars = message.toCharArray();
        for (char a : chars) {
            if (!Thread.currentThread().isInterrupted()) {
                long time = System.currentTimeMillis();
                if (a == ' ') {
                    count++;
                    System.out.println("Кол-во пробелов: " + this.count);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (System.currentTimeMillis() - time > 1000) {
                    Thread.currentThread().interrupt();
                }
            } else {
                System.out.println("Thread interrupted!");
                break;
            }
        }
    }
}
