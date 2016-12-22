package ru.asemenov.Tracker;
/**
 * Class StartUITest решение задачи части 002 урока 3.
 * @author asemenov
 * @version 1
 */
public class StartUITest {
	/**
     * Метод запуска.
	 * @param args args.
     */
    public static void main(String[] args) {
        Input input = new StubInput(new String[] {"1", "create stub item", "info", "0"});
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
    }
}
