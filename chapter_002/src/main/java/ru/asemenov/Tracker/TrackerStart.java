package ru.asemenov.Tracker;

/**
 * Class TrackerStart решение задачи части 002 урока 2.
 * @author asemenov
 * @version 1
 */
public class TrackerStart {
	/**
	* Метод запуска.
	* @param args args.
	*/
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Alex", "info"));
        for (Item item : tracker.findAll()) {
            System.out.println(item.getName());
        }
    }
}