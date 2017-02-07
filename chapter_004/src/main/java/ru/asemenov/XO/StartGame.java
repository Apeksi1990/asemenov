package ru.asemenov.XO;

public class StartGame {
    public static void main(String[] args) {
        Board board = new Board();
        CheckBoard checkBoard = new CheckBoard(board);
        Input input = new ConsoleInput();
        Player player = new Human(input, board, checkBoard);
        Player bot = new Bot(board, checkBoard);

        Game game = new Game(board, player, bot, checkBoard, input);
        game.play();
    }
}
