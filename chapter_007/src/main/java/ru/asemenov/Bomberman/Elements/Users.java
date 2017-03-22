package ru.asemenov.Bomberman.Elements;

import ru.asemenov.Bomberman.Cell;
/**
 * Abstract class Users решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public abstract class Users extends Element implements Runnable {
    /**
     * Name.
     */
    private String name;
    /**
     * Route.
     */
    private Route route = Route.DOWN;

    /**
     * Users constructor.
     * @param x position.
     * @param y position.
     * @param board Cell[][].
     * @param name user.
     */
    public Users(int x, int y, Cell[][] board, String name) {
        super(x, y, board);
        this.name = name;
    }

    /**
     * Override run.
     */
    @Override
    public void run() {
        Thread.currentThread().setName(this.name);
        while (!Thread.currentThread().isInterrupted()) {
            if (!canWalk(route)) {
                route = route.changeRoute();
                System.out.println(String.format("%s поменял направление: %s", this.name, route));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    System.out.println(String.format("%s: x-%s y-%s", this.name, getX(), getY()));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
