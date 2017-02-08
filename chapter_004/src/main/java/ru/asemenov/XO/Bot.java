package ru.asemenov.XO;
/**
 * Class Bot решение задачи части 004.
 * @author asemenov
 * @version 1
 */
public class Bot implements Player {
    /**
     * Board.
     */
    private BoardWithList board;
    /**
     * Check board.
     */
    private CheckBoard checkBoard;

    /**
     * Bot constructor.
     * @param board bord.
     * @param checkBoard check board.
     */
    public Bot(BoardWithList board, CheckBoard checkBoard) {
        this.board = board;
        this.checkBoard = checkBoard;
    }

    /**
     * Choose number.
     */
    @Override
    public void choose() {
        final int min = 1;
        final int max = this.board.getBoard().size();
        boolean correct = false;
        int key = 0;
        while (!correct) {
            key = rnd(min, max);
            correct = this.checkBoard.checkField(key);
        }
        mark(key);
    }

    /**
     * Random.
     * @param min number.
     * @param max number.
     * @return random.
     */
    private int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    /**
     * Mark board.
     * @param key key.
     */
    @Override
    public void mark(int key) {
        this.board.getBoard().set(key - 1, "O");
    }
}
