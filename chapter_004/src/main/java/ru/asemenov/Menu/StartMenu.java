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

        Item taskOne = new Item("Task", "1");
        Item subTaskOne = new Item("SubTask", "1.1", taskOne);
        Item subSubTaskOne = new Item("SubSubTask", "1.1.1", subTaskOne);
        Item subSubTaskTwo = new Item("SubSubTask", "1.1.2", subTaskOne);
        Item subTaskTwo = new Item("SubTask", "1.2", taskOne);
        Item taskTwo = new Item("Task", "2");

        menu.setItems(taskOne);
        menu.setItems(subTaskOne);
        menu.setItems(subSubTaskOne);
        menu.setItems(subSubTaskTwo);
        menu.setItems(subTaskTwo);
        menu.setItems(taskTwo);

        menu.init();
    }
}
