package ru.asemenov.Chess;
/**
 * Class Cell решение задачи части 002 урока 7.
 * @author asemenov
 * @version 1
 */
public class Cell {
    /**
     * X position.
     */
    private int x;
    /**
     * Y position.
     */
    private int y;
    /**
     * Конструктор принимающий координаты.
     * @param x x.
     * @param y y.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * X position.
     * @return x.
     */
    public int getX() {
        return this.x;
    }
    /**
     * Y position.
     * @return y.
     */
    public int getY() {
        return this.y;
    }
}
