package ru.asemenov.Bomberman.Elements;

import ru.asemenov.Bomberman.Cell;

public abstract class Element {
    private int x;
    private int y;
    private Cell[][] board;

    public Element(int x, int y, Cell[][] board) {
        this.x = x;
        this.y = y;
        this.board = board;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

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
