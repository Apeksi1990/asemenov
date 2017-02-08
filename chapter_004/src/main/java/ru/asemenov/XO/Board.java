package ru.asemenov.XO;
/**
 * Interface Board решение задачи части 004.
 * @author asemenov
 * @version 1
 */
public interface Board {
    /**
     * Set size.
     * @param size size.
     */
    void setSize(int size);

    /**
     * Return size.
     * @return size.
     */
    int getSize();

    /**
     * Fill board.
     */
    void fillBoard();

    /**
     * Print board.
     */
    void draw();
}
