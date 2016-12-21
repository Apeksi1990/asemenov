package ru.asemenov.Tracker;

import java.util.Random;

/**
 * Class Tracker решение задачи части 002 урока 2.
 * @author asemenov
 * @version 1
 */
public class Tracker {
	/**
	* Хранилище заявок.
	*/
	private final Item[] items = new Item[15];
	/**
	* Кол-во заявко.
	*/
    private int itemCount = 0;
	/**
	* Рандом для id заявки.
	*/
    private static final Random RN = new Random();
    /**
     * Генерация id.
     * @return новый id.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }
    /**
     * Добавление заявки.
     * @param item новая заявка.
     * @return item
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        item.setDate(System.currentTimeMillis());
        this.items[itemCount++] = item;
        return item;
    }
    /**
     * Редактирование заявки.
     * @param item новые данные для заявки
     */
    public void update(Item item) {
        for (int i = 0; i < itemCount; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(item.getId())) {
                this.items[i].setName(item.getName());
                this.items[i].setDescription(item.getDescription());
            }
        }
    }
    /**
     * Удалить заявку по id.
     * @param id заявки.
     */
    public void delete(String id) {
        for (int i = 0; i < itemCount; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                this.items[i] = null;
            }
        }
    }
    /**
     * Показать заявки.
     * @return result.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.itemCount];
        for (int i = 0; i < itemCount; i++) {
            result[i] = this.items[i];
        }
        return result;
    }
    /**
     * Поиск по id.
     * @param id заявки.
     * @return result.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item items : this.items) {
            if (items != null && items.getId().equals(id)) {
                result = items;
                break;
            }
        }
        return result;
    }
    /**
     * Поиск по имени.
     * @param name имя заявки.
     * @return result.
     */
    public Item[] findByName(String name) {
        int nameCount = 0;
        for (int i = 0; i < itemCount; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(name)) {
                nameCount++;
            }
        }
        Item[] result = new Item[nameCount];
        int j = 0;
        for (int i = 0; i < itemCount; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(name)) {
                result[j++] = items[i];
            }
        }
        return result;
    }
    /**
     * Добавление комментария.
     * @param id      заявки.
     * @param comment новый комментарий.
     */
    public void addComment(String id, String comment) {
        Item item = this.findById(id);
        item.addComments(comment);
    }
}
