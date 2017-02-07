package ru.asemenov.XO;

public class CheckBoard {
    private Board board;

    boolean finish = false;

    public CheckBoard(Board board) {
        this.board = board;
    }

    public boolean checkField(int key) {
        boolean result = false;
        System.out.println(key);
        if (this.board.getBoard().get(key - 1).equals(String.valueOf(key))) {
            result = true;
        }
        return result;
    }

    public boolean checkFinish(int size) {
        int i = 0;
        if (board.getBoard().get(i).equals(board.getBoard().get(i + 1)) & board.getBoard().get(i).equals(board.getBoard().get(i + 2))) {
            finish = true;
        } else if (board.getBoard().get(i).equals(board.getBoard().get(size)) & board.getBoard().get(i).equals(board.getBoard().get(size + size))) {
            finish = true;
        } else if (board.getBoard().get(i).equals(board.getBoard().get(size + 1)) & board.getBoard().get(i).equals(board.getBoard().get(size * size - 1))) {
            finish = true;
        }
        i =  i + 1;
        if (board.getBoard().get(i).equals(board.getBoard().get(i + size)) & board.getBoard().get(i).equals(board.getBoard().get(size + size + i))) {
            finish = true;
        }
        i = i + 1;
        if (board.getBoard().get(i).equals(board.getBoard().get(i + size)) & board.getBoard().get(i).equals(board.getBoard().get(size + size - 1))) {
            finish = true;
        }
        i = size;
        if (board.getBoard().get(i).equals(board.getBoard().get(i + 1)) & board.getBoard().get(i).equals(board.getBoard().get(i + 2))) {
            finish = true;
        }
        i = size + size;
        if (board.getBoard().get(i).equals(board.getBoard().get(i + 1)) & board.getBoard().get(i).equals(board.getBoard().get(i + 2))) {
            finish = true;
        }
        return finish;
    }
}
