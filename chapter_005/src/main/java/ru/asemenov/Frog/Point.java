package ru.asemenov.Frog;

public class Point {
    /**
     * X position.
     */
    private final int x;
    /**
     * E position.
     */
    private final int y;

    /**
     * Point constructor.
     * @param x position.
     * @param y position.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get X.
     * @return int.
     */
    public int getX() {
        return x;
    }

    /**
     * Get Y.
     * @return int.
     */
    public int getY() {
        return y;
    }

    /**
     * Override equals.
     * @param o Object.
     * @return boolean.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point point = (Point) o;

        if (x != point.x) {
            return false;
        }
        return y == point.y;

    }

    /**
     * Override hash code.
     * @return int.
     */
    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
