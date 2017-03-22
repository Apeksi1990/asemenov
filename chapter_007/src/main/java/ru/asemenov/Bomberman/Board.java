package ru.asemenov.Bomberman;

import ru.asemenov.Bomberman.Elements.Block;
import ru.asemenov.Bomberman.Elements.Monster;
import ru.asemenov.Bomberman.Elements.Player;
/**
 * Class Board решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class Board {
    /**
     * Board.
     */
    private final Cell[][] board;

    /**
     * Board constructor.
     * @param size int.
     */
    public Board(int size) {
        this.board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = new Cell();
            }
        }
    }

    /**
     * Add player.
     * @param player Player.
     * @param x position.
     * @param y position.
     */
    public void addPlayer(Player player, int x, int y) {
        synchronized (this.board) {
            this.board[x][y].setElement(player);
        }
    }

    /**
     * Add monster.
     * @param monster monster.
     * @param x position.
     * @param y position.
     */
    public void addMonster(Monster monster, int x, int y) {
        synchronized (this.board) {
            this.board[x][y].setElement(monster);
        }
    }

    /**
     * Add block.
     * @param x position.
     * @param y position.
     */
    public void addBlock(int x, int y) {
        synchronized (this.board) {
            this.board[x][y].setElement(new Block(x, y, this.board));
        }
    }

    /**
     * Get board.
     * @return Cell[][].
     */
    public Cell[][] getBoard() {
        return this.board;
    }
}