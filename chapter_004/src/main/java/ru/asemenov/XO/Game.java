package ru.asemenov.XO;
/**
 * Class Game решение задачи части 004.
 * @author asemenov
 * @version 1
 */
public class Game {
    /**
     * BoardXO.
     */
    private BoardWithList board;
    /**
     * Player.
     */
    private Player human;
    /**
     * Player.
     */
    private Player bot;
    /**
     * Check board.
     */
    private CheckBoard checkBoard;
    /**
     * Input.
     */
    private Input input;

    /**
     * Game constructor.
     * @param board board.
     * @param human player.
     * @param bot player.
     * @param checkBoard check board.
     * @param input input.
     */
    public Game(BoardWithList board, Player human, Player bot, CheckBoard checkBoard, Input input) {
        this.board = board;
        this.human = human;
        this.bot = bot;
        this.checkBoard = checkBoard;
        this.input = input;
    }

    /**
     * Start play game.
     */
    public void play() {
        setBoardSize();
        this.board.draw();
        boolean player = firstPlayer();
        boolean result = false;
        int count = 0;
        while (!result) {
            if (player) {
                this.human.choose();
                player = false;
            } else {
                this.bot.choose();
                player = true;
            }
            this.board.draw();
            count++;
            result = checkResult(count, player);
        }
    }

    /**
     * Check result.
     * @param count number.
     * @param player player.
     * @return boolean.
     */
    private boolean checkResult(int count, boolean player) {
        boolean result = this.checkBoard.checkFinish();
        if (result) {
            congratulations(player);
        } else if (count == this.board.getBoard().size()) {
            System.out.println("No Winners.");
            result = true;
        }
        return result;
    }

    /**
     * Choose first player.
     * @return player number.
     */
    private boolean firstPlayer() {
        System.out.println("1.Human.");
        System.out.println("2.Bot.");
        int first = Integer.parseInt(this.input.ask("Первый начинает: "));
        if (first == 1) {
            return true;
        } else if (first == 2) {
            return false;
        } else {
            throw new KeyException("Incorrect number");
        }
    }

    /**
     * Print congratulation/
     * @param key player.
     */
    private void congratulations(boolean key) {
        if (key) {
            System.out.println("Bot Win!");
        } else {
            System.out.println("Human Win!");
        }
    }

    /**
     * Set board size.
     */
    private void setBoardSize() {
        String size = this.input.ask("Размер поля: ");
        this.board.setSize(Integer.parseInt(size));
    }
}
