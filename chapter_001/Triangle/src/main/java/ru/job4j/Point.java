package ru.job4j;

/**
 * Class Point решение задачи части 001 урока 3.
 * @author asemenov
 * @version 1
 */
public class Point {
	/**
	* Координата x.
	*/
	private double x;
	/**
	* координата y.
	*/
	private double y;
	/**
	* Копирование координат x и y.
	*@param x координата
	*@param y координата
	*/
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	/**
	* Метод нахождения расстояния между двумя точками.
	*@return расстояние между точками
	*@param point координаты
	*/
	public double distanceTo(Point point) {
		double dx = this.x - point.x;
		double dy = this.y - point.y;
		return Math.sqrt(dx * dx + dy * dy);
	}
}