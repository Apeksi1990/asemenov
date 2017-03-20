package ru.asemenov.Frog;

public class Frog {
    /**
     * Route.
     */
    private Route route;
    /**
     * Field.
     */
    private Field field;
    /**
     * Start point.
     */
    private Point start;
    /**
     * Finish point.
     */
    private Point finish;
    /**
     * Min count jump.
     */
    private int min = 0;

    /**
     * Frog constructor.
     * @param field this.
     * @param start this.
     * @param finish this.
     */
    public Frog(Field field, Point start, Point finish) {
        this.field = field;
        this.start = start;
        this.finish = finish;
    }

    /**
     * Start jump.
     */
    private void startJump() {
        jump(this.start);
    }

    /**
     * Jump.
     * @param point current.
     */
    private void jump(Point point) {
        this.min++;
        if (point.equals(this.finish)) {
            stop();
        } else {
            Point newPoint = routeJump(point);
            jump(newPoint);
        }
    }

    /**
     * route jump.
     * @param point this.
     * @return Point.
     */
    private Point routeJump(Point point) {
        System.out.println(point.getX() + " " + point.getY());
        boolean result = false;
        Point newPoint = null;
        route = Route.LEFT;
        while (!result) {
            newPoint = maxX(route.route(point));
            if (this.field.canJump(newPoint)) {
                result = true;
            } else {
                route = route.changeRoute();
            }
        }
        return newPoint;
    }

    /**
     * Max X.
     * @param point this.
     * @return Point.
     */
    private Point maxX(Point point) {
        Point newPoint = point;
        if (newPoint.getX() > this.field.getxAmount()) {
            newPoint = new Point(newPoint.getX() - this.field.getxAmount(), newPoint.getY());
        }
        return newPoint;
    }

    /**
     * Stop jump.
     */
    private void stop() {
        System.out.println("Кол-во прыжков: " + this.min);
    }

    /**
     * Main.
     * @param args arg.
     */
    public static void main(String[] args) {
        Field field = new Field();
        Point start = new Point(11, 7);
        Point finish = new Point(9, 10);
        Frog frog = new Frog(field, start, finish);
        frog.startJump();
    }
}
