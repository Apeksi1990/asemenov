package ru.asemenov.Bomberman.Elements;

import ru.asemenov.Bomberman.Cell;
/**
 * Abstract class Element решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public abstract class Element {
    /**
     * X position.
     */
    private int x;
    /**
     * Y position.
     */
    private int y;
    /**
     * Board.
     */
    private Cell[][] board;

    /**
     * Element constructor.
     * @param x position.
     * @param y position.
     * @param board Cell[][].
     */
    public Element(int x, int y, Cell[][] board) {
        this.x = x;
        this.y = y;
        this.board = board;
    }

    /**
     * GEt x position.
     * @return int.
     */
    public int getX() {
        return x;
    }

    /**
     * GEt y position.
     * @return int.
     */
    public int getY() {
        return y;
    }

    /**
     * Can walk.
     * @param roure Route.
     * @return boolean.
     */
    public boolean canWalk(Route roure) {
        boolean result;
        final int distX = this.x + roure.route()[0];
        final int distY = this.y + roure.route()[1];
        if (distX >= this.board.length || distY >= this.board.length || distX < 0 || distY < 0) {
            result = false;
        } else {
            synchronized (this.board[distX][distY]) {
                if (this.board[distX][distY].getElement() == null) {
                    this.board[distX][distY].setElement(this);
                    this.board[x][y].setElement(null);
                    this.x = distX;
                    this.y = distY;
                    result = true;
                } else {
                    result = false;
                }
            }
        }
        return result;
    }
}
