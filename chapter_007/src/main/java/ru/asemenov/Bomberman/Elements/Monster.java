package ru.asemenov.Bomberman.Elements;

import ru.asemenov.Bomberman.Cell;
/**
 * Class Monster решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class Monster extends Users {
    /**
     * Monster constructor.
     * @param x position.
     * @param y position.
     * @param board Cell[][].
     * @param name monster.
     */
    public Monster(int x, int y, Cell[][] board, String name) {
        super(x, y, board, name);
    }
}
