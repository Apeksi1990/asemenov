package ru.asemenov.Chess;
/**
 * Class Slon решение задачи части 002 урока 7.
 * @author asemenov
 * @version 1
 */
public class Slon extends Figure {
    /**
     * Конструктор Slon.
     * @param position position.
     */
    Slon(Cell position) {
        super(position);
    }
    /**
     * Проверка возможности хода.
     * @param dist dist.
     * @return result.
     * @throws ImpossibleMoveException ImpossibleMove.
     */
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        int lineX = this.getPosition().getX() - dist.getX();
        int lineY = this.getPosition().getY() - dist.getY();
        if (lineX != lineY) {
            throw new ImpossibleMoveException("Impossible Move");
        }
        Cell[] result = new Cell[Math.abs(lineX)];
        for (int i = 0; i < Math.abs(lineX); i++) {
            result[i] = new Cell(this.getPosition().getX() + i + 1, this.getPosition().getY() + i + 1);
        }
        return result;
    }
    /**
     * Новая позиция фигуры.
     * @param dist dist.
     * @return new position.
     */
    public Figure clone(Cell dist) {
        return new Slon(dist);
    }
}
