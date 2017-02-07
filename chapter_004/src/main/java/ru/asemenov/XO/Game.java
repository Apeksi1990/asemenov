package ru.asemenov.XO;

public class Game {
    private Board board;
    private Player human;
    private Player bot;
    private CheckBoard checkBoard;
    private Input input;

    public Game(Board board, Player human, Player bot, CheckBoard checkBoard, Input input) {
        this.board = board;
        this.human = human;
        this.bot = bot;
        this.checkBoard = checkBoard;
        this.input = input;
    }

    public void play() {
        board.setSize(3);
        board.draw();

        int player = firstPlayer();
        boolean result = false;
        while (!result) {
            if (player == 1) {
                human.choose();
                player = 2;
            } else {
                bot.choose();
                player = 1;
            }
            board.draw();
            result = checkBoard.checkFinish(3);
        }
        congratulations(player);
    }
    private int firstPlayer() {
        System.out.println("1.Human.");
        System.out.println("2.Bot.");
        int first;
        do {
            first = Integer.parseInt(input.ask("Первый начинает: "));
        } while (!(first == 1 | first == 2));
        return first;
    }

    private void congratulations(int key) {
        if (key == 1) {
            System.out.println("Bot Win!");
        } else {
            System.out.println("Human Win!");
        }
    }
}
