package ru.asemenov.Calculator.MenuCalc;

import java.io.IOException;
/**
 * Interface InterfaceMenu решение задачи части 004 урока 2.
 * @author asemenov
 * @version 1
 */
public interface InterfaceMenu {
    /**
     * Fill action.
     */
    void fillActions();
    /**
     * Add action.
     * @param action action.
     */
    void addAction(BaseAction action);
    /**
     * Home page.
     * @throws IOException exception.
     */
    void homePage() throws IOException;
    /**
     * Start.
     * @throws IOException exception.
     */
    void start() throws IOException;
    /**
     * Result.
     */
    void result();
}
