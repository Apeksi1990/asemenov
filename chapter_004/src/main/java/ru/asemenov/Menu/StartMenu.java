package ru.asemenov.Menu;
/**
 * Class StartMenu решение задачи части 004 урока 4.
 * @author asemenov
 * @version 1
 */
public class StartMenu {
    /**
     * Main.
     * @param args args.
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Menu menu = new Menu(input);
        menu.fillItem();
        menu.show();
        menu.init();
    }
}
