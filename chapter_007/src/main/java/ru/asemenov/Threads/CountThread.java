package ru.asemenov.Threads;

public class CountThread {
    /**
     * Count space and words.
     * @param message count.
     * @throws InterruptedException exception.
     */
    public void startCount(String message) throws InterruptedException {
        Thread word = new Thread(new WordCount(message));
        Thread space = new Thread(new SpaceCount(message));
        System.out.println("Start count!");
        word.start();
        space.start();
        word.join();
        space.join();
        System.out.println("Finish count!");
    }
}