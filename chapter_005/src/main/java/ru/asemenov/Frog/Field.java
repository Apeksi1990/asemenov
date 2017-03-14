package ru.asemenov.Frog;

public class Field {
    private final int xAmount = 16;
    private final int yAmount = 10;

    private Point[] points;

    public Field(Point[] points) {
        this.points = points;
    }

    public int getxAmount() {
        return xAmount;
    }

    public int getyAmount() {
        return yAmount;
    }

    boolean isPass(Point point) {
        if (this.points != null) {
            for (Point p : this.points) {
                if (p.equals(point)) {
                    return true;
                }
            }
        }
        return false;
    }
}
