package ru.job4j.Triangle;

/**
 * Class Triangle решение задачи части 001 урока 3.
 * @author asemenov
 * @version 1
 */
public class Triangle {

	/**
	* первая вершина треугольника.
	*/
	private Point a;
	/**
	* вторая вершина треугольника.
	*/
	private Point b;
	/**
	* третья вершина треугольника.
	*/
	private Point c;
	/**
	* вершины треугольника.
	*@param a вершина треугольника
	*@param b вершина треугольника
	*@param c вершина треугольника
	*/
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	* Метод нахождения площади треугольника.
	*@return result площадь треугольника
	*/
	public double area() {
		/**
		* Нахождение длины сторон треугольника.
		*/
		double ab = a.distanceTo(b);
		double bc = b.distanceTo(c);
		double ac = a.distanceTo(c);

		/**
		* Формула Герона.
		*/
		double p = (ab + bc + ac) / 2;
		double result = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
		/**
		* Проверка на возможность нахождения
		* площади треугольника по заданным вершинам.
		*/
		if (result == 0) {
			return -1;
		} else {
			return result;
		}
	}

}