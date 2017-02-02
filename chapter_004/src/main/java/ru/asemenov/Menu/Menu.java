package ru.asemenov.Menu;

import java.util.ArrayList;
/**
 * Class Menu решение задачи части 004 урока 4.
 * @author asemenov
 * @version 1
 */
public class Menu implements Show {
    /**
     * Input.
     */
    private Input input;
    /**
     * Menu constructor.
     * @param input input.
     */
    Menu(Input input) {
        this.input = input;
    }
    /**
     * Items.
     */
    private ArrayList<Item> items = new ArrayList<>();
    /**
     * Get items.
     * @return items.
     */
    ArrayList<Item> getItem() {
        return this.items;
    }
    /**
     * Task.
     */
    private Item taskOne = new Item("Task", "1");
    /**
     * Task.
     */
    private Item subTaskOne = new Item("SubTask", "1.1", taskOne);
    /**
     * Task.
     */
    private Item subSubTaskOne = new Item("SubSubTask", "1.1.1", subTaskOne);
    /**
     * Task.
     */
    private Item subSubTaskTwo = new Item("SubSubTask", "1.1.2", subTaskOne);
    /**
     * Task.
     */
    private Item subTaskTwo = new Item("SubTask", "1.2", taskOne);
    /**
     * Task.
     */
    private Item taskTwo = new Item("Task", "2");
    /**
     * Fill item.
     */
    void fillItem() {
        items.add(taskOne);
        items.add(subTaskOne);
        items.add(subSubTaskOne);
        items.add(subSubTaskTwo);
        items.add(subTaskTwo);
        items.add(taskTwo);
    }
    /**
     * Show.
     */
    public void show() {
        for (Item item : items) {
            item.getAllAbove(item);
            item.show();
        }
    }
    /**
     * Check key.
     * @param key key.
     * @return item.
     */
    Item checkKey(String key) {
        Item result = null;
        for (Item item : getItem()) {
            if (key.equals(item.getKey())) {
                result = item;
            }
        }
        return result;
    }
    /**
     * Select item action.
     * @param key key.
     */
    private void select(String key) {
        Item item = checkKey(key);
        if (item != null) {
            item.action();
        } else {
            errorKey();
        }
    }
    /**
     * Error key.
     */
    private void errorKey() {
        System.out.println("Enter correct task key.");
    }
    /**
     * Init.
     */
    public void init() {
        do {
            String key = this.input.ask("Enter key task: ");
            select(key);
        } while (!"y".equals(this.input.ask("Exit?(y):")));
    }
}
