package ru.asemenov.Tracker;
/**
 * Interface BaseAction решение задачи части 002 урока 6.
 * @author asemenov
 * @version 1
 */
public abstract class BaseAction implements UserAction {
    /**
     * Имя метода.
     */
    private String name;
    /**
     * Конструктор принимающий имя метода.
     * @param name name.
     */
    BaseAction(String name) {
        this.name = name;
    }
    /**
     * Ключ действия.
     * @return key.
     */
    public abstract int key();
    /**
     * Действия метода.
     * @param input input.
     * @param tracker tracker.
     */
    public abstract void execute(Input input, Tracker tracker);
    /**
     * Информация о методе.
     * @return name.
     */
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }

}
