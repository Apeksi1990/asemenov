package ru.asemenov.XO;

import java.util.ArrayList;

public class Board {
    private int size;

    private ArrayList<String> board = new ArrayList<>();

    public ArrayList<String> getBoard() {
        return this.board;
    }

    public void setSize(int size) {
        this.size = size;
        fillBoard();
    }

    private void fillBoard() {
        for (int i = 0; i < this.size * this.size; i++) {
            board.add(String.valueOf(i + 1));
        }
    }
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
