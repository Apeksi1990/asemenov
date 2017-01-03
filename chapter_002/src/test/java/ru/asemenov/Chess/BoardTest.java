package ru.asemenov.Chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class BoardTest решение задачи части 002 урока 7.
 * @author asemenov
 * @version 1
 */
public class BoardTest {
    /**
     * Тест Корректности хода.
     * @throws ImpossibleMoveException ImpossibleMove.
     * @throws OccupiedWayException OccupiedWay.
     * @throws FigureNotFoundException FigureNotFound.
     */
    @Test
    public void move() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Cell start = new Cell(0, 0);
        Cell finish = new Cell(4, 4);
        Slon slon = new Slon(start);
        Board board = new Board(new Figure[]{slon});
        assertThat(board.move(start, finish), is(true));
    }
    /**
     * Тест исключения отсутствия фигуры.
     * @throws ImpossibleMoveException ImpossibleMove.
     * @throws OccupiedWayException OccupiedWay.
     * @throws FigureNotFoundException FigureNotFound.
     */
    @Test(expected = FigureNotFoundException.class)
    public void figureNotFound() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Cell start = new Cell(0, 0);
        Cell finish = new Cell(4, 4);
        Slon slon = new Slon(new Cell(1, 1));
        Board board = new Board(new Figure[]{slon});
        board.move(start, finish);
    }
    /**
     * Тест исключения правильности хода вигуры.
     * @throws ImpossibleMoveException ImpossibleMove.
     * @throws OccupiedWayException OccupiedWay.
     * @throws FigureNotFoundException FigureNotFound.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void impossibleMove() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Cell start = new Cell(0, 0);
        Cell finish = new Cell(4, 3);
        Slon slon = new Slon(start);
        Board board = new Board(new Figure[]{slon});
        board.move(start, finish);
    }
    /**
     * Тест исключения нахождения фигуры на пути хода.
     * @throws ImpossibleMoveException ImpossibleMove.
     * @throws OccupiedWayException OccupiedWay.
     * @throws FigureNotFoundException FigureNotFound.
     */
    @Test(expected = OccupiedWayException.class)
    public void occupiedWay() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Cell start = new Cell(0, 0);
        Cell finish = new Cell(4, 4);
        Slon slon1 = new Slon(start);
        Slon slon2 = new Slon(new Cell(1, 1));
        Board board = new Board(new Figure[]{slon1, slon2});
        board.move(start, finish);
    }
}
