package ru.asemenov.Menu;
/**
 * Class Item решение задачи части 004 урока 4.
 * @author asemenov
 * @version 1
 */
public class Item implements ShowAction {
    /**
     * Name.
     */
    private String name;
    /**
     * Above.
     */
    private Item above;
    /**
     * Key.
     */
    private String key;
    /**
     * Count.
     */
    private int count = 0;
    /**
     * Item constructor.
     * @param name name.
     * @param key key.
     */
    public Item(String name, String key) {
        this.name = name;
        this.key = key;
    }
    /**
     * Item constructor.
     * @param name name.
     * @param key key.
     * @param above above.
     */
    public Item(String name, String key, Item above) {
        this.name = name;
        this.key = key;
        this.above = above;
    }
    /**
     * Get name.
     * @return name and key.
     */
    public String getName() {
        return this.name + " " + this.key;
    }
    /**
     * Get key.
     * @return key.
     */
    public String getKey() {
        return this.key;
    }
    /**
     * Get above.
     * @return above.
     */
    public Item getAbove() {
        return this.above;
    }
    /**
     * Get all above.
     * @param item item.
     * @return count above.
     */
    public int getAllAbove(Item item) {
        Item parent;
        if (item.getAbove() != null) {
            parent = item.getAbove();
            count++;
            getAllAbove(parent);
        }
        return this.count;
    }
    /**
     * Show.
     */
    public void show() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.count; i++) {
            sb.append("--");
        }
        sb.append(getName());
        System.out.println(sb);
    }
    /**
     * Action.
     */
    public void action() {
        System.out.println("Выбран пунк меню: " + this.getName());
    }
}
