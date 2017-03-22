package ru.asemenov.Bomberman.Elements;

import ru.asemenov.Bomberman.Cell;
/**
 * Class Player решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class Player extends Users {
    /**
     * Player.
     * @param x position.
     * @param y position.
     * @param board Cell[][].
     * @param name player.
     */
    public Player(int x, int y, Cell[][] board, String name) {
        super(x, y, board, name);
    }
}
