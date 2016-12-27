package ru.asemenov.Tracker;
/**
 * Class MenuTracker решение задачи части 002 урока 4.
 * @author asemenov
 * @version 1
 */
public class MenuTracker {
    /**
     * this.input.
     */
    private Input input;
    /**
     * this.tracker.
     */
    private Tracker tracker;
    /**
     * Массив меню.
     */
    private UserAction[] actions = new UserAction[7];
    /**
     * Конструктор принимающий input and tracker.
     * @param input input.
     * @param tracker tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Заполнения массива меню.
     */
    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new EditItem();
        this.actions[2] = new DeleteItem();
        this.actions[3] = new ShowAll();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();
        this.actions[6] = new AddComment();
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
        System.out.println(item.getId() + " " + item.getName() + " " + item.getDescription());
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
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter the item name: ");
            String description = input.ask("Please enter the item description: ");
            tracker.add(new Item(name, description));
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
        public void execute(Input input, Tracker tracker) {
            select(3);
            String id = input.ask("Please enter the id item: ");
            String name = input.ask("Please enter the new item name: ");
            String description = input.ask("Please enter the new item description: ");
            Item item = new Item(name, description);
            item.setId(id);
            tracker.update(item);
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
        public void execute(Input input, Tracker tracker) {
            select(3);
            String id = input.ask("Please enter the id item for delete: ");
            tracker.delete(id);
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
        public void execute(Input input, Tracker tracker) {
            Item[] item = tracker.findAll();
            for (Item i : item) {
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
        public void execute(Input input, Tracker tracker) {
            try {
                select(3);
                String id = input.ask("Please enter the id item: ");
                Item result = tracker.findById(id);
                showItem(result);
            } catch (NullPointerException npe) {
                System.out.println("Incorrect id");
            }
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
        public void execute(Input input, Tracker tracker) {
            select(3);
            String name = input.ask("Please enter the item name: ");
            Item[] result = tracker.findByName(name);
            for (Item i : result) {
                showItem(i);
            }
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
        public void execute(Input input, Tracker tracker) {
            try {
                select(3);
                String id = input.ask("Please enter the id item: ");
                String comment = input.ask("Please enter the comment for item: ");
                tracker.addComment(id, comment);
            } catch (NullPointerException npe) {
                System.out.println("Incorrect id");
            }
        }
        /**
         * Информация о методе.
         */
        AddComment() {
            super("Add comment");
        }
    }
}
