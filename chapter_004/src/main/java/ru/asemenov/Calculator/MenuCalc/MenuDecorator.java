package ru.asemenov.Calculator.MenuCalc;

import java.io.IOException;
/**
 * Class MenuDecorator решение задачи части 004 урока 2.
 * @author asemenov
 * @version 1
 */
public abstract class MenuDecorator implements InterfaceMenu {
    /**
     * InterfaceMenu.
     */
    private InterfaceMenu menu;
    /**
     * MenuDecorator constructor.
     * @param menu menu.
     */
    MenuDecorator(InterfaceMenu menu) {
        this.menu = menu;
    }
    /**
     * Fill action.
     */
    @Override
    public void fillActions() {
        menu.fillActions();
    }
    /**
     * Add action.
     * @param action action.
     */
    @Override
    public void addAction(BaseAction action) {
        menu.addAction(action);
    }
    /**
     * Home page.
     * @throws IOException exception.
     */
    @Override
    public void homePage() throws IOException {
        menu.homePage();
    }
    /**
     * Start.
     * @throws IOException exception.
     */
    @Override
    public void start() throws IOException {
        menu.start();
    }
    /**
     * Result.
     */
    @Override
    public void result() {
        menu.result();
    }
}
