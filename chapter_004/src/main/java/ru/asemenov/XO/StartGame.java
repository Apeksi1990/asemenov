package ru.asemenov.XO;
/**
 * Class Main решение задачи части 004.
 * @author asemenov
 * @version 1
 */
public class StartGame {
    /**
     * Main.
     * @param args arg.
     */
    public static void main(String[] args) {
        BoardWithList board = new BoardXO();
        CheckBoard checkBoard = new CheckBoard(board);
        Input input = new ConsoleInput();
        Player player = new Human(input, board, checkBoard);
        Player bot = new Bot(board, checkBoard);

        Game game = new Game(board, player, bot, checkBoard, input);
        game.play();
    }
}
