package ru.asemenov.XO;
/**
 * Interface Player решение задачи части 004.
 * @author asemenov
 * @version 1
 */
public interface Player {
    /**
     * Choose number.
     */
    void choose();

    /**
     * Mark board.
     * @param key number.
     */
    void mark(int key);
}
