package ru.asemenov.Frog;

public class Field {
    /**
     * X max.
     */
    private final int xAmount = 16;
    /**
     * Y max.
     */
    private final int yAmount = 10;

    /**
     * Get x max.
     * @return int.
     */
    public int getxAmount() {
        return xAmount;
    }

    /**
     * Get y max.
     * @return int.
     */
    public int getyAmount() {
        return yAmount;
    }

    /**
     * Can jump.
     * @param point this.
     * @return boolean.
     */
    public boolean canJump(Point point) {
        if (point.getX() == 14 & point.getY() == 9) {
            return false;
        } else if (point.getX() == 5 & point.getY() == 8) {
            return false;
        } else if (point.getX() > getxAmount() || point.getX() < 1){
            return false;
        } else if (point.getY() > getyAmount() || point.getY() < 1) {
            return false;
        } else {
            return true;
        }
    }
}
