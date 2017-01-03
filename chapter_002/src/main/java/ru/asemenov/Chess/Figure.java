package ru.asemenov.Chess;
/**
 * Class Figure решение задачи части 002 урока 7.
 * @author asemenov
 * @version 1
 */
public abstract class Figure {
    /**
     * Position.
     */
    private final Cell position;
    /**
     * Конструктор Figure.
     * @param position position.
     */
    Figure(Cell position) {
        this.position = position;
    }
    /**
     * Проверка возможности хода.
     * @param dist dist.
     * @return result.
     * @throws ImpossibleMoveException ImpossibleMove
     */
    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;
    /**
     * Новая позиция фигуры.
     * @param dist dist.
     * @return new position.
     */
    public abstract Figure clone(Cell dist);
    /**
     * Вернуть позицию.
     * @return position.
     */
    public final Cell getPosition() {
        return position;
    }
}
