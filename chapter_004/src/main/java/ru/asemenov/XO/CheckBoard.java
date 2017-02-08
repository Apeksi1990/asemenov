package ru.asemenov.XO;
/**
 * Class CheckBoard решение задачи части 004.
 * @author asemenov
 * @version 1
 */
public class CheckBoard {
    /**
     * Board.
     */
    private BoardWithList board;
    /**
     * Finish.
     */
    private boolean finish = false;

    /**
     * CheckBoard constructor.
     * @param board board.
     */
    public CheckBoard(BoardWithList board) {
        this.board = board;
    }

    /**
     * Check board field.
     * @param key board field.
     * @return boolean.
     */
    public boolean checkField(int key) {
        boolean result = false;
        if (this.board.getBoard().get(key - 1).equals(String.valueOf(key))) {
            result = true;
        }
        return result;
    }

    /**
     * Check finish.
     * @return boolean.
     */
    public boolean checkFinish() {
        int size = this.board.getSize();
        if (checkHorizontal(size)) {
            finish = true;
        } else if (checkVertical(size)) {
            finish = true;
        } else if (checkCross(size)) {
            finish = true;
        }
        return finish;
    }

    /**
     * Horizontal check.
     * @param size board.
     * @return boolean.
     */
    private boolean checkHorizontal(int size) {
        boolean result = false;
        int count = 0;
        for (int i = 0; i < size * size;) {
            for (int j = i; j < size; j ++) {
                if (board.getBoard().get(j).equals(board.getBoard().get(i))) {
                    count++;
                } else {
                    break;
                }
            }
            if (count == size) {
                result = true;
                break;
            } else {
                count = 0;
                i = i + size;
            }
        }
        return result;
    }

    /**
     * Vertical check.
     * @param size board.
     * @return boolean.
     */
    private boolean checkVertical(int size) {
        boolean result = false;
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size * size;) {
                if (board.getBoard().get(j).equals(board.getBoard().get(i))) {
                    count++;
                    j = j + size;
                } else {
                    break;
                }
            }
            if (count == size) {
                result = true;
                break;
            } else {
                count = 0;
            }
        }
        return result;
    }

    /**
     * Cross check.
     * @param size board.
     * @return boolean.
     */
    private boolean checkCross(int size) {
        boolean result = false;
        int count = 0;
        for (int i = 0; i < size; ) {
            for (int j = i; i < size * size; ) {
                if (board.getBoard().get(j).equals(board.getBoard().get(i))) {
                    count++;
                    if (i == 0) {
                        j = j + size + 1;
                    } else {
                        j = j + size - 1;
                    }
                } else {
                    break;
                }
            }
            if (count == size) {
                result = true;
                break;
            } else {
                i = i + size - 1;
                count = 0;
            }
        }
        return result;
    }
}
