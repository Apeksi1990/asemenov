package ru.asemenov.XO;

public class Human implements Player {
    private Input input;
    private Board board;
    private CheckBoard checkBoard;

    Human(Input input, Board board, CheckBoard checkBoard) {
        this.input = input;
        this.board = board;
        this.checkBoard = checkBoard;
    }
    @Override
    public void choose() {
        int[] ranges = new int[board.getBoard().size()];
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = i + 1;
        }
        boolean correct = false;
        int key = 0;
        while (!correct) {
            key = input.ask("Выберите номер поля: ", ranges);
            correct = checkBoard.checkField(key);
        }
        mark(key);
    }
    @Override
    public void mark(int key) {
        this.board.getBoard().set(key - 1, "X");
    }
}
