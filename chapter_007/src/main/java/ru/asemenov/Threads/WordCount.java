package ru.asemenov.Threads;

import java.util.Scanner;
/**
 * Class WordCount решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class WordCount implements Runnable {
    /**
     * Count.
     */
    private int count = 0;
    /**
     * Message.
     */
    private String message;

    /**
     * WordCount constructor.
     * @param message count.
     */
    public WordCount(String message) {
        this.message = message;
    }

    /**
     * Override count.
     */
    @Override
    public void run() {
        Scanner scanner = new Scanner(this.message);
        while (scanner.hasNext()) {
            long time = System.currentTimeMillis();
            if (!Thread.currentThread().isInterrupted()) {
                scanner.next();
                this.count++;
                System.out.println("Кол-во слов: " + this.count);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
