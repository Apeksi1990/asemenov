package ru.asemenov.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    public void sort() {
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
    }
    /**
     * Set items.
     * @param item item.
     */
    public void setItems(Item item) {
        this.items.add(item);
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
        sort();
        show();
        do {
            String key = this.input.ask("Enter key task: ");
            select(key);
        } while (!"y".equals(this.input.ask("Exit?(y):")));
    }
}
