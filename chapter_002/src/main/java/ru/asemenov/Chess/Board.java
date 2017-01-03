package ru.asemenov.Chess;
/**
 * Class Board решение задачи части 002 урока 7.
 * @author asemenov
 * @version 1
 */
public class Board {
    /**
     * Массив фигур.
     */
    private Figure[] figures;
    /**
     * Конструктор принимающий фигуры.
     * @param figures figures.
     */
    Board(Figure[] figures) {
        this.figures = figures;
    }
    /**
     * Метод для движения фигуры.
     * @param source sourse.
     * @param dist dist.
     * @return true.
     * @throws ImpossibleMoveException ImpossibleMove.
     * @throws OccupiedWayException OccupiedWay.
     * @throws FigureNotFoundException FigureNotFound.
     */
    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        /*
        Наличие фигуры.
         */
        boolean currectFigure = false;
        /*
        Расположение фигуры.
         */
        Figure soureFigure = null;
        /*
        Позиция фигуры.
         */
        int positionFigure = 0;
        /*
         Проверка наличия фигуры.
         */
        for (int i = 0; i < this.figures.length; i++) {
            if (this.figures[i].getPosition().equals(source)) {
                currectFigure = true;
                soureFigure = this.figures[i];
                positionFigure = i;
            }
        }
        if (!currectFigure) {
            throw new FigureNotFoundException("Figure Not Found");
        }
        /*
        Проверка возможности хода.
         */
        Cell[] currectWay = soureFigure.way(dist);
        /*
        Проверка что на пути нет фигур.
         */
        for (Cell cell : currectWay) {
            for (Figure figure : this.figures) {
                if (figure.getPosition().equals(cell)) {
                    throw new OccupiedWayException("Occupied Way");
                }
            }
        }
        /*
        Новое положение фигуры.
         */
        this.figures[positionFigure] = soureFigure.clone(dist);

        return true;
    }
}
