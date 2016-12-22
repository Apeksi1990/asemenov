package ru.asemenov.Tracker;

import java.util.Objects;

/**
 * Class StartUI решение задачи части 002 урока 3.
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
     * Пункт меню.
     */
    private String select;

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
        while (!Objects.equals(this.select, "0")) {
            showMenu();
            String action = this.input.ask("Please select an action: ");
            this.select = action;
            selectSwitch(action);
        }
    }
    /**
     * Выбор меню.
     * @param action action.
     */
    private void selectSwitch(String action) {
        switch (action) {
            case "1":
                addItem();
                break;
            case "2":
                editItem();
                break;
            case "3":
                deleteItem();
                break;
            case "4":
                showAll();
                break;
            case "5":
                findIdItem();
                break;
            case "6":
                findNameItem();
                break;
            case "7":
                addComment();
                break;
			default:
				System.out.println("Error.");
        }
    }
    /**
     * Пункты меню.
     */
    private void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Добавить заявку");
        System.out.println("2. Обновить заявку");
        System.out.println("3. Удалить заявку");
        System.out.println("4. Показать все заявки");
        System.out.println("5. Найти заявку по id");
        System.out.println("6. Найти заявки с именем");
        System.out.println("7. Добавить комментарий к заявке");
        System.out.println("0. Exit");
    }
    /**
     * Добавить заявку.
     */
    private void addItem() {
        String name = this.input.ask("Please enter the item name: ");
        String description = this.input.ask("Please enter the item description: ");
        this.tracker.add(new Item(name, description));
        System.out.println("Заявка добавлена");
    }
    /**
     * Редактировать заявку.
     */
    private void editItem() {
        showAll();
        String id = this.input.ask("Please enter the id item: ");
        String name = this.input.ask("Please enter the new item name: ");
        String description = this.input.ask("Please enter the new item description: ");
        Item item = new Item(name, description);
        item.setId(id);
        this.tracker.update(item);
        System.out.println("Заявка обновлена");
    }
    /**
     * Удалить заявку.
     */
    private void deleteItem() {
        showAll();
        String id = this.input.ask("Please enter the id item for delete: ");
        this.tracker.delete(id);
        System.out.println("Заявка удалена");
    }
    /**
     * Показать все заявки.
     */
    private void showAll() {
        Item[] item = this.tracker.findAll();
        for (Item i : item) {
            showItem(i);
        }
    }
    /**
     * Найти по id.
     */
    private void findIdItem() {
        String id = this.input.ask("Please enter the id item: ");
        Item result = this.tracker.findById(id);
        showItem(result);
    }
    /**
     * Найти по имени.
     */
    private void findNameItem() {
        String name = this.input.ask("Please enter the item name: ");
        Item[] result = this.tracker.findByName(name);
        for (Item i : result) {
            showItem(i);
        }
    }
    /**
     * Добавить комментарий.
     */
    private void addComment() {
        showAll();
        String id = this.input.ask("Please enter the id item: ");
        String comment = this.input.ask("Please enter the comment for item: ");
        this.tracker.addComment(id, comment);
    }
    /**
     * Показать заявку.
     * @param item item
     */
    private void showItem(Item item) {
        System.out.println(item.getId() + " " + item.getName() + " " + item.getDescription());
    }
    /**
     * Метод запуска.
     * @param args args
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
    }
}