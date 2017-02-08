package ru.asemenov.XO;
/**
 * Class Human решение задачи части 004.
 * @author asemenov
 * @version 1
 */
public class Human implements Player {
    /**
     * Input.
     */
    private Input input;
    /**
     * Board.
     */
    private BoardWithList board;
    /**
     * Check board.
     */
    private CheckBoard checkBoard;

    /**
     * Human constructor.
     * @param input input.
     * @param board board.
     * @param checkBoard check board.
     */
    Human(Input input, BoardWithList board, CheckBoard checkBoard) {
        this.input = input;
        this.board = board;
        this.checkBoard = checkBoard;
    }

    /**
     * Choose number.
     */
    @Override
    public void choose() {
        int[] ranges = new int[this.board.getBoard().size()];
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = i + 1;
        }
        boolean correct = false;
        int key = 0;
        while (!correct) {
            key = this.input.ask("Выберите номер поля: ", ranges);
            correct = this.checkBoard.checkField(key);
        }
        mark(key);
    }

    /**
     * Mark board.
     * @param key key.
     */
    @Override
    public void mark(int key) {
        this.board.getBoard().set(key - 1, "X");
    }
}
