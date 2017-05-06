package ru.asemenov.jdbc;
/**
 * Interface Input решение задачи части 002 урока 4.
 * @author asemenov
 * @version 1
 */
public interface UserAction {
    /**
     * Ключ действия.
     * @return key.
     */
    int key();
    /**
     * Действия метода.
     * @param input input.
     * @param tracker tracker.
     */
    void execute(Input input, TrackerSQL tracker);
    /**
     * Информация о методе.
     * @return info.
     */
    String info();
}