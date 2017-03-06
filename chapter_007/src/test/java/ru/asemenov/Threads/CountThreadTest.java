package ru.asemenov.Threads;

import org.junit.Test;
/**
 * Class CountThreadTest решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class CountThreadTest {
    /**
     * Thread test.
     * @throws InterruptedException exception.
     */
    @Test
    public void threadTest() throws InterruptedException {
        CountThread countThread = new CountThread();
        countThread.startCount("Привет жаба лесная куда идёшь");
    }
}