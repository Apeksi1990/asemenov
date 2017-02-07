package ru.asemenov.XO;

public class Bot implements Player {
    private Board board;
    private CheckBoard checkBoard;

    public Bot(Board board, CheckBoard checkBoard) {
        this.board = board;
        this.checkBoard = checkBoard;
    }

    @Override
    public void choose() {
        final int min = 1;
        final int max = board.getBoard().size();
        boolean correct = false;
        int key = 0;
        while (!correct) {
            key = rnd(min, max);
            correct = checkBoard.checkField(key);
        }
        mark(key);
    }

    private int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
    @Override
    public void mark(int key) {
        this.board.getBoard().set(key - 1, "O");
    }
}
