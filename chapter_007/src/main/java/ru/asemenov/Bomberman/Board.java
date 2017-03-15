package ru.asemenov.Bomberman;

import ru.asemenov.Bomberman.Elements.Block;
import ru.asemenov.Bomberman.Elements.Monster;
import ru.asemenov.Bomberman.Elements.Player;

public class Board {

    private final Cell[][] board;

    public Board(int size) {
        this.board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = new Cell();
            }
        }
    }

    public void addPlayer(Player player, int x, int y) {
        synchronized (this.board) {
            this.board[x][y].setElement(player);
        }
    }

    public void addMonster(Monster monster, int x, int y) {
        synchronized (this.board) {
            this.board[x][y].setElement(monster);
        }
    }

    public void addBlock(int x, int y) {
        synchronized (this.board) {
            this.board[x][y].setElement(new Block(x, y, this.board));
        }
    }

    public Cell[][] getBoard() {
        return this.board;
    }
}