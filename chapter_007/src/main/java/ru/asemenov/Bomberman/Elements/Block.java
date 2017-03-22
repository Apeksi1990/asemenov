package ru.asemenov.Bomberman.Elements;

import ru.asemenov.Bomberman.Cell;
/**
 * Class Block решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class Block extends Element {
    /**
     * Block constructor.
     * @param x position.
     * @param y position.
     * @param board Cell[][].
     */
    public Block(int x, int y, Cell[][] board) {
        super(x, y, board);
    }

    /**
     * Override can walk.
     * @param route Route.
     * @return boolean.
     */
    @Override
    public boolean canWalk(Route route) {
        return false;
    }
}
