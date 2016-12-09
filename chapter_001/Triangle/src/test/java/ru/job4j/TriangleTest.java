package ru.job4j;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Class TriangleTest решение задачи части 001 урока 3.
 * @author asemenov
 * @version 1
 */
public class TriangleTest {
	/**
	* x координата первой вершины треугольника.
	*/
	private final double ten = 10.0;
	/**
	* y координата первой и третьей вершины треугольника.
	*/
	private final double fifteen = 15.0;
	/**
	* x координата первой вершины треугольника.
	*/
	private final double nine = 9.0;
	/**
	* y координата первой вершины треугольника.
	*/
	private final double twelve = 12.0;
	/**
	* x координата первой вершины треугольника.
	*/
	private final double three = 3.0;
	/**
	* возможная ошибка теста.
	*/
	private final double closeError = 0.01;
	/**
	* Первое расстояние между точками.
	*/
	private final double answerDistOne = 3.16d;
	/**
	* Второе расстояние между точками.
	*/
	private final double answerDistTwo = 7d;
	/**
	* Третье расстояние между точками.
	*/
	private final double answerDistThree = 6.7d;
	/**
	* Площадь треугольника.
	*/
	private final double triangleArea = 10.5d;
	/**
	* координаты первой вершины треугольника.
	*/
	private Point point1 = new Point(ten, fifteen);
	/**
	* координаты второй вершины треугольника.
	*/
	private Point point2 = new Point(nine, twelve);
	/**
	* координаты третьей вершины треугольника.
	*/
	private Point point3 = new Point(three, fifteen);
	/**
	* ссылка на класс Triangle.
	*/
	private Triangle triangle = new Triangle(point1, point2, point3);

	/**
	* Тестирование расстояния между точками.
	*/
	@Test
	public void whenGiveTwoPointsThenGiveDistant() {
		assertThat(point1.distanceTo(point2), closeTo(answerDistOne, closeError));
		assertThat(point1.distanceTo(point3), closeTo(answerDistTwo, closeError));
		assertThat(point2.distanceTo(point3), closeTo(answerDistThree, closeError));
	}

	/**
	* Тестирование нахождения площади треугольника.
	*/
	@Test
	public void whenGiveTriangleGiveArea() {
		assertThat(triangle.area(), closeTo(triangleArea, closeError));
	}
}
