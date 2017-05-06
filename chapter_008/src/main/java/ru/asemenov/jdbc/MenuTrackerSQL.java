package ru.asemenov.jdbc;

import java.util.ArrayList;
/**
 * Class MenuTrackerSQL решение задачи части 008.
 * @author asemenov
 * @version 1
 */
public class MenuTrackerSQL {
    /**
     * this.input.
     */
    private Input input;
    /**
     * this.tracker.
     */
    private TrackerSQL tracker;
    /**
     * Массив меню.
     */
    private UserAction[] actions = new UserAction[7];
    /**
     * Конструктор принимающий input and tracker.
     * @param input input.
     * @param tracker tracker.
     */
    public MenuTrackerSQL(Input input, TrackerSQL tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Заполнения массива меню.
     */
    public void fillActions() {
        this.actions[0] = new MenuTrackerSQL.AddItem();
        this.actions[1] = new MenuTrackerSQL.EditItem();
        this.actions[2] = new MenuTrackerSQL.DeleteItem();
        this.actions[3] = new MenuTrackerSQL.ShowAll();
        this.actions[4] = new MenuTrackerSQL.FindById();
        this.actions[5] = new MenuTrackerSQL.FindByName();
        this.actions[6] = new MenuTrackerSQL.AddComment();
    }
    /**
     * Размер меню.
     * @return range.
     */
    public int getRange() {
        return actions.length;
    }
    /**
     * Выбор пункта меню.
     * @param key key.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }
    /**
     * Показать пункты меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    /**
     * Показать заявку.
     * @param item item.
     */
    private void showItem(Item item) {
        System.out.println(String.format("%s %s %s %s", item.getId(), item.getName(), item.getDescription(), item.getDate()));
    }
    /**
     * Добавить заявку.
     */
    private class AddItem extends BaseAction {
        /**
         * Номер метода.
         * @return number.
         */
        public int key() {
            return 0;
        }
        /**
         * Действие метода.
         * @param input input.
         * @param tracker tracker.
         */
        public void execute(Input input, TrackerSQL tracker) {
            String name = input.ask("Please enter the item name: ");
            String description = input.ask("Please enter the item description: ");
            tracker.add(name, description);
            System.out.println("Заявка добавлена");

        }
        /**
         * Информация о методе.
         */
        AddItem() {
            super("Add the new item.");
        }
    }
    /**
     * Редактировать заявку.
     */
    private class EditItem extends BaseAction {
        /**
         * Номер метода.
         * @return number.
         */
        public int key() {
            return 1;
        }
        /**
         * Действие метода.
         * @param input input.
         * @param tracker tracker.
         */
        public void execute(Input input, TrackerSQL tracker) {
            select(3);
            String id = input.ask("Please enter the id item: ");
            String name = input.ask("Please enter the new item name: ");
            String description = input.ask("Please enter the new item description: ");
            tracker.update(Integer.parseInt(id), name, description);
            System.out.println("Заявка обновлена");
        }
        /**
         * Информация о методе.
         */
        EditItem() {
            super("Edit item.");
        }
    }
    /**
     * Удалить заявку.
     */
    private class DeleteItem extends BaseAction {
        /**
         * Номер метода.
         * @return number.
         */
        public int key() {
            return 2;
        }
        /**
         * Действие метода.
         * @param input input.
         * @param tracker tracker.
         */
        public void execute(Input input, TrackerSQL tracker) {
            select(3);
            String id = input.ask("Please enter the id item for delete: ");
            tracker.delete(Integer.parseInt(id));
            System.out.println("Заявка удалена");
        }
        /**
         * Информация о методе.
         */
        DeleteItem() {
            super("Delete item.");
        }
    }
    /**
     * Показать все заявки.
     */
    private class ShowAll extends BaseAction {
        /**
         * Номер метода.
         * @return number.
         */
        public int key() {
            return 3;
        }
        /**
         * Действие метода.
         * @param input input.
         * @param tracker tracker.
         */
        public void execute(Input input, TrackerSQL tracker) {
            ArrayList<Item> result = tracker.findAll();
            for (Item i : result) {
                showItem(i);
            }
        }
        /**
         * Информация о методе.
         */
        ShowAll() {
            super("Show all item.");
        }
    }
    /**
     * Найти по id.
     */
    private class FindById extends BaseAction {
        /**
         * Номер метода.
         * @return number.
         */
        public int key() {
            return 4;
        }
        /**
         * Действие метода.
         * @param input input.
         * @param tracker tracker.
         */
        public void execute(Input input, TrackerSQL tracker) {
            select(3);
            String id = input.ask("Please enter the id item: ");
            Item result = tracker.findById(Integer.parseInt(id));
            showItem(result);
        }
        /**
         * Информация о методе.
         */
        FindById() {
            super("Find item by id.");
        }
    }
    /**
     * Найти по имени.
     */
    private class FindByName extends BaseAction {
        /**
         * Номер метода.
         * @return number.
         */
        public int key() {
            return 5;
        }
        /**
         * Действие метода.
         * @param input input.
         * @param tracker tracker.
         */
        public void execute(Input input, TrackerSQL tracker) {
            select(3);
            String name = input.ask("Please enter the item name: ");
            Item result = tracker.findByName(name);
            showItem(result);
        }
        /**
         * Информация о методе.
         */
        FindByName() {
            super("Find item by name.");
        }
    }
    /**
     * Добавить комментарий.
     */
    private class AddComment extends BaseAction {
        /**
         * Номер метода.
         * @return number.
         */
        public int key() {
            return 6;
        }
        /**
         * Действие метода.
         * @param input input.
         * @param tracker tracker.
         */
        public void execute(Input input, TrackerSQL tracker) {
            select(3);
            String id = input.ask("Please enter the id item: ");
            String comment = input.ask("Please enter the comment for item: ");
            tracker.addComment(Integer.parseInt(id), comment);
        }
        /**
         * Информация о методе.
         */
        AddComment() {
            super("Add comment");
        }
    }
}
