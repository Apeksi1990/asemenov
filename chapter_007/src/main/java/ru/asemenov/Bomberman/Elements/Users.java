package ru.asemenov.Bomberman.Elements;

import ru.asemenov.Bomberman.Cell;

public abstract class Users extends Element implements Runnable {

    private String name;

    private Route route = Route.DOWN;

    public Users(int x, int y, Cell[][] board, String name) {
        super(x, y, board);
        this.name = name;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.name);
        while (!Thread.currentThread().isInterrupted()) {
            if (!canWalk(route)) {
                route = route.changeRoute();
                System.out.println(String.format("%s change route: %s", this.name, route));
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
