package ru.asemenov.Tracker;
/**
 * Class StartUI решение задачи части 002 урока 4.
 * @author asemenov
 * @version 1
 */
public class StartUI {
	/**
     * this.input.
     */
    private Input input;
	/**
     * this.tracker.
     */
    private Tracker tracker;
	/**
     * StartUI.
     * @param input input.
	 * @param tracker tracker.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
	/**
     * Вывод меню.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        int[] ranges = new int[menu.getRange()];
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = i;
        }
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("Select:", ranges));
        } while (!"y".equals(this.input.ask("Exit?(y):")));
    }
    /**
     * Метод запуска.
     * @param args args
     */
    public static void main(String[] args) {
        Input input = new ValidateInput();
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
    }
}