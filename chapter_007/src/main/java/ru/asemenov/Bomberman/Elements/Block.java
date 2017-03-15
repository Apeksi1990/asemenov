package ru.asemenov.Bomberman.Elements;

import ru.asemenov.Bomberman.Cell;

public class Block extends Element {

    public Block(int x, int y, Cell[][] board) {
        super(x, y, board);
    }

    @Override
    public boolean canWalk(Route route) {
        return false;
    }
}
