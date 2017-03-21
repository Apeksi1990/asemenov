package ru.asemenov.Frog;
/**
 * Class Field.
 * @author asemenov
 * @version 1
 */
public class Field {
    /**
     * X max.
     */
    private final int maxX = 16;
    /**
     * Y max.
     */
    private final int maxY = 10;

    /**
     * Get x max.
     * @return int.
     */
    public int getMaxX() {
        return maxX;
    }

    /**
     * Get y max.
     * @return int.
     */
    public int getMaxY() {
        return maxY;
    }

    /**
     * Can jump.
     * @param point this.
     * @return boolean.
     */
    public boolean canJump(Point point) {
        if (point.getX() == 14 & point.getY() == 9) {
            return false;
        }
        if (point.getX() == 5 & point.getY() == 8) {
            return false;
        }
        if (point.getY() > getMaxY() || point.getY() < 1) {
            return false;
        }
        return true;
    }
}
