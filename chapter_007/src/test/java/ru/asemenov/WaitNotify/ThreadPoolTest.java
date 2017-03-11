package ru.asemenov.WaitNotify;

import org.junit.Test;
import ru.asemenov.WaitNotify.Pool.ThreadPool;
import ru.asemenov.WaitNotify.Pool.Work;
/**
 * Class ThreadPoolTest решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class ThreadPoolTest {
    /**
     * ThreadPool test.
     */
    @Test
    public void whenAddWorkThenCorrectThreadPool() {
        ThreadPool pool = new ThreadPool();
        for (int i = 0; i < 20; i++) {
            pool.add(new Work(String.format("Element %s", String.valueOf(i))));
        }
    }

}