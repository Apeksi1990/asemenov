package ru.asemenov.XO;

import java.util.ArrayList;
/**
 * Class BoardXO решение задачи части 004.
 * @author asemenov
 * @version 1
 */
public class BoardXO implements BoardWithList {
    /**
     * Size.
     */
    private int size;

    /**
     * Board.
     */
    private ArrayList<String> board = new ArrayList<>();

    /**
     * Return board.
     * @return board.
     */
    public ArrayList<String> getBoard() {
        return this.board;
    }

    /**
     * Set board size.
     * @param size length.
     */
    public void setSize(int size) {
        this.size = size;
        fillBoard();
    }

    /**
     * Return size board.
     * @return size.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Fill board.
     */
    public void fillBoard() {
        for (int i = 0; i < this.size * this.size; i++) {
            this.board.add(String.valueOf(i + 1));
        }
    }

    /**
     * Draw board.
     */
    public void draw() {
        StringBuilder sb = new StringBuilder();
        int lenght = 0;
        for (int i = 0; i < this.board.size(); i++) {
            sb.append("|").append(this.board.get(i)).append("|");
            lenght++;
            if (lenght == this.size) {
                sb.append("\r\n");
                lenght = 0;
            }
        }
        System.out.println(sb);
    }
}
